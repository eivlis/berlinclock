package com.hotels.silvievyhnankova.berlinclock.service;


public class ConsolePrinter implements Printer {

    @Override
    public void printLine(String line) {
        System.out.println(line);
    }
}
