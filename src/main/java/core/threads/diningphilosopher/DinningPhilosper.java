package core.threads.diningphilosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DinningPhilosper {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSPER);
        Philosper[] philospers = new Philosper[Constants.NUMBER_OF_PHILOSPER];
        ChopStick[] chopSticks = new ChopStick[Constants.NUMBER_OF_CHOPSTICKS];
        for(int i=0;i<Constants.NUMBER_OF_CHOPSTICKS;i++){
            chopSticks[i] = new ChopStick(i);
        }
        for(int i=0;i<Constants.NUMBER_OF_PHILOSPER;i++){
            philospers[i] = new Philosper(i,chopSticks[i],chopSticks[(i+1)%Constants.NUMBER_OF_CHOPSTICKS]);
            executorService.execute(philospers[i]);
        }
        Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
        for(Philosper philosper : philospers){
            philosper.setFull(true);
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){
            Thread.sleep(1000);
        }
        for(Philosper philosper : philospers){
            System.out.println("Philosper  "+philosper.getId()+"  Eating counter " +philosper.getEatingCounter());
        }

    }
}
