import java.util.HashMap;
import java.util.Map;

public class Dog implements Pets, Attribute {
    private HashMap<Integer, String> happiness;
    private HashMap<Integer, String> hunger;
    private Color color;

    public Dog(HashMap<Integer, String> happiness, HashMap<Integer, String> hunger, Color color){
        this.happiness = happiness; //2 attributes
        this.hunger = hunger;
        this.color = color;
    }


    @Override
    public void play(){
        makeSound(); //happy dog sounds
        System.out.println("Dog is frolicking.");
        incrementValue(happiness); //happy dog is a tired dog
        incrementValue(hunger); //hungry from burning calories
    }

    @Override
    public void feed(){
        System.out.println("Dog is being fed...");
        decrementValue(hunger); //not as hungry
        incrementValue(happiness); //happy = food
        makeSound(); //happy barks
        System.out.println("Dog is feeling nourished!");
    }

    @Override
    public void makeSound(){
        System.out.println("Arf! Arf!!!");
    }

    @Override
    public HashMap<Integer, String> getAttribute1(){
        return happiness;
    }

    @Override
    public HashMap<Integer, String> getAttribute2(){
        return hunger;
    }
    
    @Override
    public Color getColor(){
        return color;
    }

    public String printAttribute1(){
        return "happiness"; //for menu purposes
    }
    public String printAttribute2(){
        return "hunger"; //for menu purposes
    }

    public void incrementValue(HashMap<Integer, String> map){
        HashMap<Integer, String> updatedMap = new HashMap<>(); //store updated valyes
        for (Map.Entry<Integer, String> entry : map.entrySet()) { //look through given  map
            int key = entry.getKey(); 
            if (key < 5) {
                updatedMap.put(key + 1, mapValueToString(key + 1));
            } else {
                updatedMap.put(key, entry.getValue()); // if the key is at max, dont chane
            }
        }
        map.clear();
        map.putAll(updatedMap);
    }

    public void decrementValue(HashMap<Integer, String> map){
        HashMap<Integer, String> updatedMap = new HashMap<>();//store updated valyes
        for (Map.Entry<Integer, String> entry : map.entrySet()) {//look through given  map
            int key = entry.getKey();
            if (key > 0) { // dont go beyond 0
                updatedMap.put(key - 1, mapValueToString(key - 1));
            } else {
                updatedMap.put(key, entry.getValue()); // if the key is at max, dont chane
            }
        }
        map.clear();
        map.putAll(updatedMap);
    }

    public String getValue(Integer key, HashMap<Integer, String> map){
        return map.getOrDefault(key, "key not found"); //returns normal unless key not found
    }

    public Integer getCurrentValue(Integer key, HashMap<Integer, String> map){
        String value = map.get(key);
        if (value != null) {
            return Integer.parseInt(value);
        } else {
            return -1; //key not found return something else
        }
    }

    public String mapValueToString(int value) { // 0:Bad... 
        switch (value) {
            case 0:
                return "Bad";
            case 1:
                return "Ok";
            case 2:
                return "Fine";
            case 3:
                return "Good";
            case 4:
                return "Satisfied";
            case 5:
                return "Living it up";
            default:
                return "too far gone..";
        }
    }
}

