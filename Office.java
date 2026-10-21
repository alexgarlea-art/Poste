import java.util.Random;

public class Office extends Thread{
    public static Queue queue;
    public Office(Queue queue){
        Office.queue = queue;
    }

    public void run(){
        Random rand = new Random();
        while(true){
            try {
                Operations toRemove = Operations.getRandom();
                if(!queue.isInQueue(toRemove)){
                    IO.println("Cannot find a " + toRemove + " ticket, trying another one in 5s...");
                    Thread.sleep(5000);
                }else{
                    IO.println("Executing operation " + toRemove + "...");
                    Thread.sleep(rand.nextInt(2000, 10000));
                    IO.println(queue.dequeue(toRemove).toString());
                }
            } catch (InterruptedException e) {
                System.err.println("Office interrupted");
                throw new RuntimeException(e);
            }
        }
    }
}
