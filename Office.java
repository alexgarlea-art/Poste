import java.util.Random;

public class Office extends Thread{
    public static Queue queue;
    public Office(Queue queue){
        Office.queue = queue;
    }

    public  void run(){
        Random rand = new Random();
        while(true){
            IO.println(queue);
            try {
                Operations toRemove = Operations.getRandom();
                if(queue.dequeue(toRemove) == null){
                    Thread.sleep(1500);
                }else{
                    Thread.sleep(rand.nextInt(1000, 10000));
                }
            } catch (InterruptedException e) {
                System.err.println("Office interrupted");
                throw new RuntimeException(e);
            }
        }
    }
}
