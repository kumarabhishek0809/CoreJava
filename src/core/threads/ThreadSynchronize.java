package core.threads;

public class ThreadSynchronize {
	public static void main(String[] args) {
		Worker threads[] = new Worker[3];
		for(int i = 0; i < 3 ; i++){
			threads[i] = new Worker("ThreadName : "+i);
		}
		
		int index = 0;
		while(true){
			synchronized (threads[index]) {
				threads[index].notify();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			index = (++index) % 3;
		}
		
	}
}


class Worker implements Runnable{

	private String name = "";
	public Worker(String name){
		this.name = name;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while(true){
			synchronized(this){ // Take Lock on Current Object
				try{
					wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				System.out.println(name + " ");
			}
		}
		
	}
}