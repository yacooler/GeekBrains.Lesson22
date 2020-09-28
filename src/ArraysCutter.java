import java.util.LinkedList;
import java.util.List;

/*
Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
(по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
 */
public class ArraysCutter{

    public Integer[] cut(Integer[] arrayToCut) {

        if (arrayToCut == null) return null;
        //Использую связанный список, т.к. массив заранее неизвестной величины и доступа к нему не требуется
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

