import java.io.Serializable;
import java.util.HashMap;

public interface Pets extends Serializable { //base
    static final long serialVersionUID = -3828861162265193048L;
    void play();
    void feed();
    void makeSound();
    HashMap<Integer, String> getAttribute1();
    HashMap<Integer, String> getAttribute2();
    String printAttribute1();
    String printAttribute2();
    Color getColor();
}
