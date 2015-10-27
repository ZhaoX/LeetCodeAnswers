package utils;

import java.util.Arrays;

/**
 * Created by zhaoxin on 15/10/26.
 */
public class Utils {

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static int max(int a, int b) {
        return a>b?a:b;
    }
}
