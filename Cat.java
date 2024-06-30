import java.util.HashMap;
import java.util.Map;

public class Cat implements Pets, Attribute {
    private HashMap<Integer, String> energy;
    private HashMap<Integer, String> thirst;
    private Color color;

    public Cat(HashMap<Integer, String> energy, HashMap<Integer, String> thirst, Color color){
        this.energy = energy; //2 attributes
        this.thirst = thirst;
        this.color = color;
    }


    @Override
    public void play(){
        makeSound(); //happy cat sounds
        System.out.println("Cat is jumping around gleefully.");
        decrementValue(energy); //happy cat is a tired cat
        incrementValue(thirst); //thirsty from burning calories
    }

    @Override
    public void feed(){
        System.out.println("Cat is being fed...");
        incrementValue(thirst); //salty food probs
        incrementValue(energy); //energy = food
        makeSound(); //happy meows
        System.out.println("Cat is feeling nourished!");
    }

    @Override
    public void makeSound(){
        System.out.println("mowww.. mowwwwwww"); //classic cat sounds
    }

    @Override
    public HashMap<Integer, String> getAttribute1(){
        return energy;
    }

    @Override
    public HashMap<Integer, String> getAttribute2(){
        return thirst;
    }
    
    @Override
    public Color getColor(){
        return color;
    }

    public String printAttribute1(){
        return "energy"; //for menu purposes
    }
    public String printAttribute2(){
        return "thirst"; //for menu purposes
    }

    public void incrementValue(HashMap<Integer, String> map){
        HashMap<Integer, String> updatedMap = new HashMap<>(); //store updated valyes
        for (Map.Entry<Integer, String> entry : map.entrySet()) {//look through given  map
            int key = entry.getKey(); 
            if (key < 5) {
                updatedMap.put(key + 1, mapValueToString(key + 1)); //++
            } else {
                updatedMap.put(key, entry.getValue()); // if the key is at max, dont chane
            }
        }
        map.clear();
        map.putAll(updatedMap);
    }
    public void decrementValue(HashMap<Integer, String> map){
        HashMap<Integer, String> updatedMap = new HashMap<>(); //store updated valyes
        for (Map.Entry<Integer, String> entry : map.entrySet()) {//look through given  map
            int key = entry.getKey();
            if (key > 0) { // dont go beyond 0
                updatedMap.put(key - 1, mapValueToString(key - 1)); //-- 
            } else {
                updatedMap.put(key, entry.getValue()); // if the key is at max, dont chane
            }
        }
        map.clear(); //clr og values make sure only updated value
        map.putAll(updatedMap);  //put all in updated map
    }

    public String getValue(Integer key, HashMap<Integer, String> map){
        return map.getOrDefault(key, "key not found"); //returns value unless key not found
    }

    public Integer getCurrentValue(Integer key, HashMap<Integer, String> map){
        String value = map.get(key);
        if (value != null) {
            return Integer.parseInt(value); //string to interger
        } else {
            return -1; //key not found return something else
        }
    }

    public String mapValueToString(int value) { //constant states 
        switch (value) {
            case 0:
                return "Depressed";
            case 1:
                return "Ok";
            case 2:
                return "Fine";
            case 3:
                return "Good";
            case 4:
                return "Happy";
            case 5:
                return "Living it up";
            default:
                return "too far gone.."; //if somehow goes above 5 or under 0
        }
    }
}

