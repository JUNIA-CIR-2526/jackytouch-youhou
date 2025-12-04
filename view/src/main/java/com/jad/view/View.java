package com.jad.view;

import com.jad.share.IView;

import java.util.List;
import java.util.Scanner;

public class View implements IView {

    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void displayCar(List<String> asciiLines) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          VOTRE VOITURE TUNING          ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        for (String line : asciiLines) {
            System.out.println(line);
        }

        System.out.println();
    }

    @Override
    public int displayMenu(String title, List<String> options) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(title);
        System.out.println("=".repeat(50));

        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, options.get(i));
        }

        return readInt("\nVotre choix : ", 1, options.size()) - 1;
    }

    @Override
    public String readInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);

                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("⚠ Veuillez entrer un nombre entre %d et %d.%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Entrée invalide. Veuillez entrer un nombre.");
            }
        }
    }

    @Override
    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {

            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    public void displayError(String message) {
        System.err.println("\n❌ ERREUR : " + message + "\n");
    }

    public void displaySuccess(String message) {
        System.out.println("\n✓ " + message + "\n");
    }

    public void waitForEnter() {
        System.out.print("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }
}