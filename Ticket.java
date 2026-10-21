public class Ticket{
    private final Operations type;
    private final int number;
    private final long start;
    private long finish;

    public Ticket(Operations type, long start, int n) {
        this.number = n;
        this.type = type;
        this.start = start;
    }

    /**
     * @return the Ticket's type
     */
    public Operations getType(){
        return this.type;
    }

    public long getStart() {
        return this.start;
    }

    public long getFinish() {
        return this.finish;
    }

    public void evade(){
        this.finish = System.currentTimeMillis();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return this.type.toString();
    }
}
