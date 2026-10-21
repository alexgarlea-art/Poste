import java.util.Random;

public enum Operations {
    P, //Packs
    F, //Financial
    A; //Payments

    public static Operations getRandom(){
        Random rand = new Random();

        switch (rand.nextInt(3)){
            case 0 -> {
                return P;
            }
            case 1 -> {
                return F;
            }
            case 2 -> {
                return A;
            }
            default -> {
                System.out.println("Exited from switch");
                return null;
            }
        }
    }
}
