public static Queue queue = new Queue();
public static Totem totem = new Totem(queue);

void main() {
    totem.start();
    IO.println(queue);

}
