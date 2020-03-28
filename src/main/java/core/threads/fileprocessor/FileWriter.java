package core.threads.fileprocessor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		String file = "/server.log";
        System.out.println("Writing to file: " + file);
        //Path path = Paths.get(FileWriter.class.getResource(file).getPath());
        
        URI uri = ClassLoader.getSystemResource("core/threads/fileprocessor/").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath ,file);
        System.out.println(path);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			for(int i = 1; i < 900000; i++) {
            writer.write("Java,Python,Clojure,Scala,JavaScript\n");
			}
        } 

	}

}
