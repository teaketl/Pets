import java.io.File;
import java.io.IOException;
import java.io.Serializable;

class FileHandler implements Serializable {
    static final long serialVersionUID = -3828861162265193048L;
    
    public static void serialize(Object obj, String filename) {
        try {
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream(filename);
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(obj); //write obj
            out.close(); //prev leaks
            fileOut.close();
            System.out.println("Serialized data is saved in " + filename); //user message for conv
        } catch (java.io.IOException e) {
            System.out.println("Error occured serializing: " + e.getMessage());//catch errors and give message
        }
    }

    public static Object deserialize(String filename) { //any object 
        Object obj = null;
        try {
            java.io.FileInputStream fileIn = new java.io.FileInputStream(filename);
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            obj = in.readObject(); //read obj
            in.close(); //prev leaks
            fileIn.close();
            System.out.println("Deserialized data from " + filename); //user message for conv
        } catch (java.io.IOException | ClassNotFoundException e) { //catch errors and give message
            System.out.println("Error occured deserializing: " + e.getMessage());
        }
        return obj; //return it after reading
    }

    public static boolean fileExists(String filename){ //check if file exists
        File file = new File(filename);
        if (file.exists()){
            System.out.println("File " + filename + " exists.");
        } else {
            try {
                if(file.createNewFile()){
                    System.out.println("File " + filename + " doesnt exist... creating new file..");
                    return false; //bc file didnt already exist
                } else {
                    System.out.println("File " + filename + " couldn't be created.");
                    return false; //bc file didnt already exist
                }
            } catch (IOException e){
                System.out.println("Error occured while checking file " + e.getMessage());
            }
        }
        return true; //if file already exusts
    }
}
