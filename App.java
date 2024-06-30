import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, String> dogHappinessMap = new HashMap<>();
        HashMap<Integer, String> dogHungerMap = new HashMap<>();
        HashMap<Integer, String> catEnergyMap = new HashMap<>();
        HashMap<Integer, String> catThirstMap = new HashMap<>();
            
        Dog dog;
        Cat cat;
        Owner ownerDog;
        Owner ownerCat;

        ownerDog = (Owner) FileHandler.deserialize("ownerDog.ser");
        ownerCat = (Owner) FileHandler.deserialize("ownerCat.ser");

        if (ownerDog == null || ownerCat == null) {
            dog = new Dog(dogHappinessMap, dogHungerMap, Color.BROWN);
            // give initial values for dog
            dogHappinessMap.put(5, "Happy");
            dogHungerMap.put(0, "Hungry");
            ownerDog = new Owner((Pets) dog);

            // give initial values for cat
            catEnergyMap.put(5, "Energetic"); // full energy
            catThirstMap.put(0, "Quenched"); // starts not thirsty
            cat = new Cat(catEnergyMap, catThirstMap, Color.WHITE);
            ownerCat = new Owner((Pets) cat);
        } else {
            dog = (Dog) FileHandler.deserialize("dog.ser");
            cat = (Cat) FileHandler.deserialize("cat.ser");
        }

        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice != 2){
            System.out.println("Choose a pet to hang out with: ");
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            choice = input.nextInt();

            if (choice == 1){
                System.out.println("\n--- Dog Menu ---"); // menu for dog
                ownerDog.menu();

                FileHandler.serialize(dog, "dog.ser");//store dog
                FileHandler.serialize(ownerDog, "ownerDog.ser");//store dogs owner

            } else if (choice == 2){
                System.out.println("\n--- Cat Menu ---"); // menu for cat
                ownerCat.menu();
                FileHandler.serialize(cat, "cat.ser"); //store cat
                FileHandler.serialize(ownerCat, "ownerCat.ser"); //store cats owner
            } else {
                System.out.println("Not a choice...");
            }
        }
        input.close();
    }
}
