package core.threads.fileprocessor;
//
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class Split {
	public static void main(String[] args) throws IOException {

		// String source = args[0];
		String source = "Server.log";

		// String output = args[1];
		String output = "Server.log.split";

		List<String> splitFiles = splitFiles(source, output);
		splitFiles.parallelStream().forEach(fileName -> System.out.println(fileName));

	}

	/**
	 * @param source
	 * @param output
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<String> splitFiles(String source, String output) throws FileNotFoundException, IOException {
		long splitSize = 128 * 1024000; // 128 Megabytes file chunks
		int bufferSize = 256 * 1024000; // 256 Megabyte memory buffer for reading source file

		List<String> filesToBeProcessed = new ArrayList<String>();
		FileChannel sourceChannel = null;
		try {
			sourceChannel = new FileInputStream(Split.class.getResource(source).getPath()).getChannel();

			ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);

			long totalBytesRead = 0; // total bytes read from channel
			long totalBytesWritten = 0; // total bytes written to output

			double numberOfChunks = Math.ceil(sourceChannel.size() / (double) splitSize);
			int padSize = (int) Math.floor(Math.log10(numberOfChunks) + 1);
			String outputFileFormat = "%s.%0" + padSize + "d";

			FileChannel outputChannel = null; // output channel (split file) we are currently writing
			long outputChunkNumber = 0; // the split file / chunk number
			long outputChunkBytesWritten = 0; // number of bytes written to chunk so far

			try {
				for (int bytesRead = sourceChannel.read(buffer); bytesRead != -1; bytesRead = sourceChannel
						.read(buffer)) {
					totalBytesRead += bytesRead;

					System.out.println(String.format("Read %d bytes from channel; total bytes read %d/%d ", bytesRead,
							totalBytesRead, sourceChannel.size()));

					buffer.flip(); // convert the buffer from writing data to buffer from disk to reading mode

					int bytesWrittenFromBuffer = 0; // number of bytes written from buffer

					String outputName = "";
					while (buffer.hasRemaining()) {
						if (outputChannel == null) {
							outputChunkNumber++;
							outputChunkBytesWritten = 0;

							outputName = Split.class.getResource("").getPath()
									+ String.format(outputFileFormat, output, outputChunkNumber);
							System.out.println(String.format("Creating new output channel %s", outputName));
							outputChannel = new FileOutputStream(outputName).getChannel();
						}

						long chunkBytesFree = (splitSize - outputChunkBytesWritten); // maxmimum free space in chunk
						int bytesToWrite = (int) Math.min(buffer.remaining(), chunkBytesFree);
						/* maximum bytes that should be read from current byte buffer */

						System.out.println(String.format(
								"Byte buffer has %d remaining bytes; chunk has %d bytes free; writing up to %d bytes to chunk",
								buffer.remaining(), chunkBytesFree, bytesToWrite));

						buffer.limit(bytesWrittenFromBuffer + bytesToWrite); // set limit in buffer up to where bytes
																				// can be read

						int bytesWritten = outputChannel.write(buffer);

						outputChunkBytesWritten += bytesWritten;
						bytesWrittenFromBuffer += bytesWritten;
						totalBytesWritten += bytesWritten;

						System.out.println(String.format(
								"Wrote %d to chunk; %d bytes written to chunk so far; %d bytes written from buffer so far; %d bytes written in total",
								bytesWritten, outputChunkBytesWritten, bytesWrittenFromBuffer, totalBytesWritten));

						buffer.limit(bytesRead); // reset limit
						filesToBeProcessed.add(outputName);

						if (totalBytesWritten == sourceChannel.size()) {
							System.out.println("Finished writing last chunk");
							closeChannel(outputChannel);
							outputChannel = null;
							break;
						} else if (outputChunkBytesWritten == splitSize) {
							System.out.println("Chunk at capacity; closing()");
							closeChannel(outputChannel);
							outputChannel = null;
						}
					}

					buffer.clear();
				}
			} finally {
				closeChannel(outputChannel);
			}
		} finally {
			closeChannel(sourceChannel);
		}
		return filesToBeProcessed;
	}

	private static void closeChannel(FileChannel channel) {
		if (channel != null) {
			try {
				channel.close();
			} catch (Exception ignore) {
				;
			}
		}
	}
}