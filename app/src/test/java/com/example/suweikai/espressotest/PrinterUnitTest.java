package com.example.suweikai.espressotest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by suweikai on 2018/8/9.
 */

public class PrinterUnitTest {
    private Printer printer;

    @Before
    public void init() {
        printer = new Printer();
    }

    @Test
    public void print() {
        assertEquals("prt:aaa", printer.print("aaa"));
    }
}
