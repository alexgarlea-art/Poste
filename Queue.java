public class Queue extends List<Ticket> {

    public Queue() {
        super();
    }

    public synchronized void enqueue(Ticket value) {
        this.addTail(value);
    }

    public synchronized Ticket dequeue() {
        Node<Ticket> tempHead = this.getHead();
        tempHead.getValue().evade();
        return this.removeHead();
    }

    public synchronized Ticket dequeue(Operations value) {
        if (this.getHead() == null) {
            System.out.println(
                    "List empty, couldn't find a value " + value + "."
            );
            return null;
        }

        Node<Ticket> cur = this.getHead();

        //Search for the item to remove
        while (cur != null && cur.getValue().getType() != value) {
            cur = cur.getNext();
        }

        if (cur == null) {
            System.out.println("Value " + value + " not found.");
            return null;

        } else if (cur == this.getHead()) {
            Node<Ticket> tempHead = this.getHead();
            tempHead.getValue().evade();
            return this.removeHead();

        } else if (cur == this.getTail()) {
            Node<Ticket> tempTail = this.getTail();
            tempTail.getValue().evade();
            return this.removeTail();

        } else {
            //save the two nodes to link together
            Node<Ticket> prev = cur.getPrev();
            Node<Ticket> next = cur.getNext();

            //link the nodes together
            prev.setNext(next);
            next.setPrev(prev);

            //delete the cur links
            cur.setPrev(null);
            cur.setNext(null);

            //evade the ticket
            cur.getValue().evade();
            return cur.getValue();
        }
    }

    public synchronized boolean isInQueue(Operations value) {

        if (this.getHead() == null) { // if the queue is empty, value cannot be in queue
            return false;
        }

        Node<Ticket> cur = this.getHead();

        //Search for the item to remove
        while (cur != null && cur.getValue().getType() != value) {
            cur = cur.getNext();
        }

        return cur != null; // if the cur is null, the cursor has reached the end of the list without finding anything
    }

    @Override
    public synchronized String toString(){
        return super.toString();
    }
}



