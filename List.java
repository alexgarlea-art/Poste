public class List<T> {
    private Node<T> head;
    private Node<T> tail;

    //Constructor
    public List(){
    }

    //Methods
    public Node<T> getHead(){
        return this.head;
    }

    public Node<T> getTail(){
        return this.tail;
    }

    public void addHead(T value){
        if(this.head == null){
            this.head = new Node<T>(value);
            this.tail = this.head;
        }else{
            Node<T> newNode = new Node<T>(value);
            this.head.setPrev(newNode);
            this.head.getPrev().setNext(this.head);
            this.head = newNode;
        }
    }

    public void addTail(T value){
        if(this.tail == null){
            this.tail = new Node<T>(value);
            this.head = this.tail;
        }else{
            Node<T> newNode = new Node<T>(value);
            this.tail.setNext(newNode);
            this.tail.getNext().setPrev(this.tail);
            this.tail = newNode;
        }
    }

    public void setHead(Node<T> node){
        this.head = node;
    }

    public void setTail(Node<T> node){
        this.tail = node;
    }

    public int size(){
        int count = 0;
        Node<T> cur = this.head;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public Node<T> getNodeAt(int index){
        if (index < 0 || index >= this.size()) {
            System.out.println("index " + index + " out of bounds");
            return null;
        }

        Node<T> cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    public T removeHead(){
        T temp = this.head.getValue();
        this.head = this.head.getNext();
        this.head.getPrev().setNext(null);
        this.head.setPrev(null);
        return temp;
    }

    public T removeTail(){
        T temp = this.tail.getValue();
        this.tail = this.tail.getPrev();
        this.tail.getNext().setPrev(null);
        this.tail.setNext(null);
        return temp;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> cur = this.head;
        while (cur != null) {
            sb.append(cur.getValue());
            if (cur.getNext() != null) {
                sb.append(", ");
            }
            cur = cur.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

}