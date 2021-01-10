package com.arolla.bankmgm.api.printers;

/**
 * Created by aminebechraoui, on 10/01/2021, in com.arolla.bankmgm.api.printers
 */
public interface Printer<T> {
    public static final String SEP = ", ";

    void print(T toPrint);
}
