package org.kuxoca.lesson3;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException() {
        super("wrong array size");
    }

    public MyArraySizeException(String msg) {
        super(msg);
    }

}
