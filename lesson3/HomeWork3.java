package lesson3;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {

        // Задание 1

        int[] array1 = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        System.out.println("Задание 1");
        printArray1("Before:\t", array1);
        change(array1);
        printArray1("After:\t", array1);

        System.out.println("*******************************");

        // Задание 2

        int[] array2 = new int[100];
        System.out.println("Задание 2");
        fillIn(array2);
        printArray1("Values:\t", array2);

        System.out.println("************************************");

        // Задание 3

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задание 3");
        printArray1("Before:\t", array3);
        doubling(array3);
        printArray1("After:\t", array3);

        System.out.println("************************************");

        // Задание 4
        int side = 10;
        int[][] array4 = new int[side][side];
        crossFill(array4);
        printArray2("Задание 4", array4);

        System.out.println("**************************************");

        // Задание 5

        int[] returnArrayFromMethod = returnArray(10, 999);
        System.out.println("Задание 5");
        printArray1("Array from method", returnArrayFromMethod);

        System.out.println("***********************************************************");

        // Задание 6
        System.out.println("Задание 6");
        printArray1("Find min & max in array\t", array3);

        System.out.println("Minimum: " + findMin(array3));
        System.out.println("Maximum: " + findMax(array3));

        System.out.println("**********************************************************");

        // Задание 7
        int[] balance = {1, 1, 1, 1, 1, 1, 6};
        System.out.println("Задание 7");
        System.out.print("Is the " + Arrays.toString(balance) + " balanced? ");
        System.out.println(checkBalance(balance));
        Arrays.toString(balance);

        System.out.println("********************************************");

    }


    // Вспомогательные методы

    public static void printArray1(String msg, int[] inputArray) {
        System.out.print(msg + ": ");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }


    public static void printArray2(String msg, int[][] inputArray) {
        System.out.println(msg);
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void change(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
//        array[i] = (array[i] == 1) ? 0 : 1;
//        array[i] = 1 - array[i];
    }

    public static void fillIn(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
    }

    public static void doubling(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6)
                array[i] *= 2;
    }

    public static void crossFill(int[][] arr) {
        int abc = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][abc - i] = 1;
        }
    }

    public static int[] returnArray(int len, int initValue) {
        int[] tempArray = new int[len];

        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = initValue;
        }

        return tempArray;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static boolean checkBalance(int[] array) {
        int right = 0, left = 0;
        for (int i = 0; i < array.length - 1; i++) {
            left += array[i];
            for (int j = i + 1; j < array.length; j++)
                right += array[j];
            if (left == right) return true;
            right = 0;
        }
        return false;
    }
}


