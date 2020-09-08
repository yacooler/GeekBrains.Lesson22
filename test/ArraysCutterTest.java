import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class ArraysCutterTest {
    private ArraysCutter arraysCutter;

    @BeforeEach
    public void initEveryTime(){
        //Эта инициализация происходит перед каждым тестом
        arraysCutter = new ArraysCutter();
    }

    @ParameterizedTest
    @NullSource
    public void testCutNull(Integer[] arr){
        //Проверка на то, что нет исключений
        Assertions.assertDoesNotThrow(()->{
            arraysCutter.cut(arr);
        });
    }

    @ParameterizedTest
    @EmptySource
    public void testCutEmpty(Integer[] arr){
        //Проверка на то, что бросился RuntimeException, т.к. нет 4ки
        Assertions.assertThrows(RuntimeException.class, ()->{
            arraysCutter.cut(arr);
        });
    }

    @Test
    public void testCutNotContains4(){
        //Проверка на то, что бросился RuntimeException, т.к. нет 4ки
        Assertions.assertThrows(RuntimeException.class, ()->{
            arraysCutter.cut(new Integer[]{1,2,5,7,6,0,9,12,3});
        });
    }

    @Test
    public void testContainsOnly4(){
        //Проверка на то, что в массиве передали только одну цифру - 4
        Assertions.assertArrayEquals(
                new Integer[]{},
                arraysCutter.cut(new Integer[]{4}));
    }

    @Test
    public void testContainsOnly4s(){
        //Проверка на то, что в массиве передали несколько цифр 4
        Assertions.assertArrayEquals(
                new Integer[]{},
                arraysCutter.cut(new Integer[]{4,4,4,4,4}));
    }

    @Test
    public void testContains4atLastPosition(){
        //Проверка на то, что в массиве передали несколько цифр 4
        Assertions.assertArrayEquals(
                new Integer[]{},
                arraysCutter.cut(new Integer[]{1,2,3,4}));
    }

    @Test
    public void testContains4atFirstPosition(){
        //Проверка на то, что в массиве передали несколько цифр 4
        Assertions.assertArrayEquals(
                new Integer[]{3,2,1},
                arraysCutter.cut(new Integer[]{4,3,2,1}));
    }

    @Test
    public void testContains4andAnother(){
        //Проверка на то, что в массиве передали несколько цифр 4
        Assertions.assertArrayEquals(
                new Integer[]{1,7},
                arraysCutter.cut(new Integer[]{1,2,4,4,2,3,4,1,7}));
    }
}
