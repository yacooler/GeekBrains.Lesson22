

/*
Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */
public class ArraysChecker {
    boolean checkArray(Integer[] arrayToCheck){

        if (arrayToCheck == null) return false;

        for (Integer check: arrayToCheck ) {
            if (check == 1 || check == 4) {
                return true;
            }
        }
        return false;
    }
}
