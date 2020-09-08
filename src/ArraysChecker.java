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
