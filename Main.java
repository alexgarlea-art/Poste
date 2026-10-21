public static Queue queue = new Queue();
public static Totem totem = new Totem(queue);
public static Office office = new Office(queue);
void main() {
    totem.start();
    office.start();
}
