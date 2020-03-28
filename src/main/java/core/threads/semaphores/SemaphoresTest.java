package core.threads.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
    INSTANCE;

    private Semaphore semaphore = new Semaphore(100, true);

    public void downloadData() {
        try {
            semaphore.acquire();
            download(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }


    }

    private void download(int i) {
        System.out.println("Dowunloading Data from web :::" + i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class SemaphoresTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for(int i =0 ;i<500;i++){
            executorService.execute(()->{
                Downloader.INSTANCE.downloadData();
            });
        }

    }
}
