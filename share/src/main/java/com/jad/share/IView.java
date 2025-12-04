package com.jad.share;

import java.util.List;


public interface IView {
    void display(String message);

    void displayCar(List<String> asciiLines);

    int displayMenu(String title, List<String> options);

    String readInput(String prompt);

    int readInt(String prompt, int min, int max);

    void clear();
}