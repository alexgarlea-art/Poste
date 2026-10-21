
public class Totem extends Thread{
    private int ticketN;
    public static Queue queue;

    public Totem(Queue queue){
        Totem.queue = queue;
        this.ticketN = 0;
    }

    public Ticket getTicket(Operations o){
        this.ticketN++;
        return new Ticket(o, System.currentTimeMillis(), ticketN-1);
    }

    public void run(){
       while(true){
           IO.println(queue);
           try {
               queue.enqueue(getTicket(Operations.getRandom()));
               Thread.sleep(100);
           } catch (InterruptedException e) {
               System.err.println("Totem interrupted");
               throw new RuntimeException(e);
           }
       }
    }

}
