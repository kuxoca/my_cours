package org.kuxoca.lesson3;

import java.util.Arrays;

public class L3Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"11", "2", "3", "4"},
                {"12", "2", "0", "4"},
                {"13", "2", "3", "4"},
                {"14", "2", "3", "4"},
        };

        try {
            System.out.println("The sum of the array elements is: " + method(arr));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            exception.printStackTrace();
        }
    }

    static int method(String[][] arr) {
        if (arr.length > 4) {
            throw new MyArraySizeException();
        }

        if (Arrays.stream(arr).anyMatch(el -> el.length > 4)) {
            throw new MyArraySizeException();
        }

        try {
            return Arrays.stream(arr).mapToInt(el -> Arrays.stream(el).mapToInt(Integer::valueOf).sum()).sum();
        } catch (NumberFormatException NFE) {
            throw new MyArrayDataException();
        }
    }
}