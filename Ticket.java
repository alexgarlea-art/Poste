public class Ticket{
    private final Operations type;
    private final int number;
    private final long start;
    private long elapsedTime;

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

    public long getElapsedTime() {
        return this.elapsedTime;
    }

    public void evade(){
        this.elapsedTime = System.currentTimeMillis() - start;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format(
                "%-16s|%-15s|%n" +
                "%-16s|%-15s|%n" +
                "%-16s|%-15d|%n" +
                "\n\n",
                "Ticket Number:", this.number,
                "Operation Type:", this.type,
                "Time Used:", elapsedTime);
    }
}
