import java.util.Objects;

public class Queue extends List<Ticket> {
    public Queue(){
        super();
    }

    public void enqueue(Ticket value){
        this.addTail(value);
    }

    public Ticket dequeue(){
        Node<Ticket> tempHead = this.getHead();
        tempHead.getValue().evade();
        return this.removeHead();
    }

    public Ticket dequeue(Operations value){
            if (this.getHead() == null) {
                System.out.println(
                        "List empty, couldn't find a value " + value + "."
                );
                return null;
            }

            Node<Ticket> cur = this.getHead();

            //Search for the item to remove
            while (cur != null && cur.getValue().getType() != value){
                cur = cur.getNext();
            }

            if (cur == null) {

                System.out.println("Value " + value + " not found.");
                return null;

            }else if (cur == this.getHead()) {
                Node<Ticket> tempHead = this.getHead();
                tempHead.getValue().evade();
                return this.removeHead();

            }else if (cur == this.getTail()) {
                Node<Ticket> tempTail = this.getTail();
                tempTail.getValue().evade();
                return this.removeTail();

            }else{
                Node<Ticket> prev = cur.getPrev();
                Node<Ticket> next = cur.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                cur.setPrev(null);
                cur.setNext(null);
                cur.getValue().evade();
                return cur.getValue();
            }
        }
    }

