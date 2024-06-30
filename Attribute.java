import java.io.Serializable;
import java.util.HashMap;

public interface Attribute extends Serializable {
    static final long serialVersionUID = -3828861162265193048L;

    void incrementValue(HashMap<Integer, String> map);
    void decrementValue(HashMap<Integer, String> map);
    String getValue(Integer key, HashMap<Integer, String> map);
    Integer getCurrentValue(Integer key, HashMap<Integer, String> map);
}
