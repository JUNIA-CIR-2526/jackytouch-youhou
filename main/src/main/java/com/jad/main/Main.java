package com.jad.main;

import com.jad.controller.Controller;
import com.jad.share.IController;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("DÉMARRAGE DE L'APPLICATION");
            IController controller = new Controller();
            System.out.println("CONTROLLER CRÉÉ");
            controller.start();
            System.out.println("APPLICATION TERMINÉE");
        } catch (Exception e) {
            System.err.println("\n ERREUR FATALE LE PC VA EXPLOSER:" + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}