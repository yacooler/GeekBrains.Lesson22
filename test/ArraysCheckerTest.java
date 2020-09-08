import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysCheckerTest {
    private static ArraysChecker arraysChecker;

    @BeforeAll
    public static void init(){
        //Какая-то инициализация, которая делается один раз перед всемми тестами
        //из-за этого она статик
        arraysChecker = new ArraysChecker();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testCheckArrayEmptyOrNull(Integer[] arr){
        //Проверка на то, что нет исключений
        assertDoesNotThrow(()->{
            arraysChecker.checkArray(arr);
        });
        //Проверка на возврат false
        assertFalse(arraysChecker.checkArray(arr));
    }

    @Test
    public void testCheckArrayContains14(){
        //Проверка на то, что нет исключений
        assertDoesNotThrow(()->{
            arraysChecker.checkArray(new Integer[]{1,6,7,12,33,4,5,8,2,1,9});
        });
        //Проверка на возврат true
        assertTrue(arraysChecker.checkArray(new Integer[]{1, 6, 7, 12, 33, 4, 5, 8, 2, 1, 9}));
    }

    @Test
    public void testCheckArrayContains1(){
        //Проверка на то, что нет исключений
        assertDoesNotThrow(()->{
            arraysChecker.checkArray(new Integer[]{0,2,0,9,1,6,7});
        });
        //Проверка на возврат false
        assertTrue(arraysChecker.checkArray(new Integer[]{0, 2, 0, 9, 1, 6, 7}));
    }

    @Test
    public void testCheckArrayContains4(){
        //Проверка на то, что нет исключений
        assertDoesNotThrow(()->{
            arraysChecker.checkArray(new Integer[]{8,2,3,9,6,6,4});
        });
        //Проверка на возврат true
        assertTrue(arraysChecker.checkArray(new Integer[]{8,2,3,9,6,6,4}));
    }

    @Test
    public void testCheckArrayNotContains14(){
        //Проверка на то, что нет исключений
        assertDoesNotThrow(()->{
            arraysChecker.checkArray(new Integer[]{8,2,3,9,6,6,12,6,11});
        });
        //Проверка на возврат false, т.к. не содержит искомого
        assertFalse(arraysChecker.checkArray(new Integer[]{8, 2, 3, 9, 6, 6, 12, 6, 11}));
    }
}
