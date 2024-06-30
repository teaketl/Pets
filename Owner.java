import java.io.Serializable;
import java.util.Scanner;

public class Owner implements Serializable {
    static final long serialVersionUID = -3828861162265193048L;
    private Pets pet; //any pet

    public Owner(Pets pet){
        this.pet = pet; //any pet
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice !=6) {
            System.out.println("1. Play with your pet");
            System.out.println("2. Give your pet sustenense.");
            System.out.println("3. See pet's color");
            System.out.println("4. See pet's " + pet.printAttribute1() + " level." );
            System.out.println("5. See pet's " + pet.printAttribute2() + " level." );
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    pet.play();
                    break;
                case 2:
                    pet.feed();
                    break;
                case 3:
                    if (pet instanceof Dog) { //allows to not seperate into two menus since they do basicall the same stuff
                        System.out.println("Dog's color: " + ((Dog) pet).getColor());
                    } else if (pet instanceof Cat) {
                        System.out.println("Cat's color: " + ((Cat) pet).getColor());
                    }
                    break;
                case 4:
                    if (pet instanceof Dog) {//allows to not seperate into two menus since they do basicall the same stuff
                        System.out.println("Dog's happiness: " + ((Dog) pet).getAttribute1());
                    } else if (pet instanceof Cat) {
                        System.out.println("Cat's energy: " + ((Cat) pet).getAttribute1());
                    }
                    break;
                case 5:
                    if (pet instanceof Dog) { //allows to not seperate into two menus since they do basicall the same stuff
                        System.out.println("Dog's hunger: " + ((Dog) pet).getAttribute2());
                    } else if (pet instanceof Cat) {
                        System.out.println("Cat's thirst: " + ((Cat) pet).getAttribute2());
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong answer! Please enter a number between 1 and 6.");
            }
        }
        input.close();
    }
}
