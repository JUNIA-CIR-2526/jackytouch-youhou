package com.jad.main;

import com.jad.controller.Controller;
import com.jad.share.IController;


public class Main {

    public static void main(String[] args) {
        try {
            IController controller = new Controller();
            controller.start();
        } catch (Exception e) {
            System.err.println("\n❌ ERREUR FATALE LE PC VA EXPLOSER : " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}