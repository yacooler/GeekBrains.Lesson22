import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        Integer[] ret = new ArraysCutter().cut(new Integer[]{1, 2, 2, 5, 3, 5, 4, 1, 2, 3, 5, 5, 9});
        for (Integer i: ret) {
            System.out.println(i);
        }

    }
}

