import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ArraysCheckerTest {
    private static ArraysChecker arraysChecker;

    @BeforeAll
    public static void init(){
        //Какая-то инициализация
        arraysChecker = new ArraysChecker();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {})
    public void testCheckArrayEmptyOrNull(Integer[] arr){
        //Проверка на то, что нет исключений
        Assertions.assertDoesNotThrow(()->{
            arraysChecker.checkArray(arr);
        });
        //Проверка на возврат false
        Assertions.assertEquals(arraysChecker.checkArray(arr), false);
    }

    @ParameterizedTest
    @CsvSource(
            {"1,6,7,12,33,4,5,8,2,1,9"}
    )
    public void testCheckArrayContains14(Integer[] arr){
        //Проверка на то, что нет исключений
        Assertions.assertDoesNotThrow(()->{
            arraysChecker.checkArray(arr);
        });
        //Проверка на возврат true
        Assertions.assertEquals(arraysChecker.checkArray(arr), true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,2,0,9,1,6,7})
    public void testCheckArrayContains1(Integer[] arr){
        //Проверка на то, что нет исключений
        Assertions.assertDoesNotThrow(()->{
            arraysChecker.checkArray(arr);
        });
        //Проверка на возврат false
        Assertions.assertEquals(arraysChecker.checkArray(arr), true);
    }

    @ParameterizedTest
    @ValueSource(ints = {8,2,3,9,6,6,4})
    public void testCheckArrayContains4(Integer[] arr){
        //Проверка на то, что нет исключений
        Assertions.assertDoesNotThrow(()->{
            arraysChecker.checkArray(arr);
        });
        //Проверка на возврат true
        Assertions.assertEquals(arraysChecker.checkArray(arr), true);
    }

    @ParameterizedTest
    @ValueSource(ints = {8,2,3,9,6,6,12,6,11})
    public void testCheckArrayNotContains14(Integer[] arr){
        //Проверка на то, что нет исключений
        Assertions.assertDoesNotThrow(()->{
            arraysChecker.checkArray(arr);
        });
        //Проверка на возврат true
        Assertions.assertEquals(arraysChecker.checkArray(arr), false);
    }
}
