import java.util.LinkedList;
import java.util.List;

public class ArraysCutter{

    public Integer[] cut(Integer[] arrayToCut) {
        List<Integer> ret = new LinkedList<>();
        for (int i = arrayToCut.length - 1; i >= 0 ; i--) {
            if (arrayToCut[i] == 4){
                for (int j = i + 1; j < arrayToCut.length; j++) {
                    ret.add(arrayToCut[j]);
                }
                return ret.toArray(new Integer[ret.size()]);
            }
        }
        throw new RuntimeException("4 is not found at array");
    }
}

