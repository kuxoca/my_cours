package org.kuxoca.lesson3;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException() {
        super("there is something wrong in the array cell");
    }

    public MyArrayDataException(String msg) {
        super(msg);
    }

}
