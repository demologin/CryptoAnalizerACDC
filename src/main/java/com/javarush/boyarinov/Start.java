package com.javarush.boyarinov;


import com.javarush.boyarinov.view.Selection;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Selection selection = new Selection(new Scanner(System.in));
        selection.selectionCommand();

    }


}
