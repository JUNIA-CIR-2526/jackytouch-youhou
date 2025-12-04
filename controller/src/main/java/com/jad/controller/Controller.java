package com.jad.controller;

import com.jad.model.Car;
import com.jad.model.tuning.Tuning;
import com.jad.share.ICar;
import com.jad.share.IController;
import com.jad.view.View;

import java.util.ArrayList;
import java.util.List;


public class Controller implements IController {

    private ICar car;
    private View view;
    private boolean running;

    public Controller() {
        this.car = new Car();
        this.view = new View();
        this.running = true;
    }

    @Override
    public void start() {
        view.clear();

        view.display(" BIENVENUE DANS LE CONFIGURATEUR DE JACKYTOUCH TUNING !");

        while (running) {
            showMainMenu();
        }

        view.display("\nMerci d'avoir utilisé le configurateur. À bientôt !\n");
    }

    private void showMainMenu() {
        List<String> options = new ArrayList<>();
        options.add("Afficher la voiture");
        options.add("Gérer les tunings (activer/désactiver)");
        options.add("Modifier les réglages mécaniques");
        options.add("Afficher le journal de configuration");
        options.add("Quitter");

        int choice = view.displayMenu("MENU PRINCIPAL", options);

        switch (choice) {
            case 0:
                displayCar();
                break;
            case 1:
                manageTunings();
                break;
            case 2:
                manageSettings();
                break;
            case 3:
                displayLog();
                break;
            case 4:
                running = false;
                break;
        }
    }

    @Override
    public void displayCar() {
        view.clear();
        List<String> renderedCar = car.render();
        view.displayCar(renderedCar);
        view.waitForEnter();
    }

    @Override
    public void manageTunings() {
        view.clear();

        List<String> tuningNames = car.getAvailableTunings();
        List<String> options = new ArrayList<>();

        for (String tuningName : tuningNames) {
            String status = car.isTuningActive(tuningName) ? "[ACTIVÉ]" : "[DÉSACTIVÉ]";
            options.add(tuningName + " " + status);
        }
        options.add("Retour au menu principal");

        int choice = view.displayMenu("GESTION DES TUNINGS", options);

        if (choice < tuningNames.size()) {
            String selectedTuning = tuningNames.get(choice);
            toggleTuning(selectedTuning);
        }
    }

    private void toggleTuning(String tuningName) {
        if (car.isTuningActive(tuningName)) {
            car.deactivateTuning(tuningName);
            view.displaySuccess(tuningName + " désactivé.");
        } else {
            car.activateTuning(tuningName);
            view.displaySuccess(tuningName + " activé.");
        }
        view.waitForEnter();
    }

    @Override
    public void manageSettings() {
        view.clear();

        List<String> activeTunings = new ArrayList<>();
        for (String tuningName : car.getAvailableTunings()) {
            if (car.isTuningActive(tuningName)) {
                activeTunings.add(tuningName);
            }
        }

        if (activeTunings.isEmpty()) {
            view.displayError("Aucun tuning actif. Activez d'abord des tunings !");
            view.waitForEnter();
            return;
        }

        List<String> options = new ArrayList<>(activeTunings);
        options.add("Retour au menu principal");

        int choice = view.displayMenu("MODIFIER LES RÉGLAGES MÉCANIQUES", options);

        if (choice < activeTunings.size()) {
            String selectedTuning = activeTunings.get(choice);
            changeSettingFor(selectedTuning);
        }
    }

    private void changeSettingFor(String tuningName) {
        view.clear();


        Tuning tuning = ((Car) car).getTuning(tuningName);

        if (tuning == null) {
            view.displayError("Tuning introuvable.");
            view.waitForEnter();
            return;
        }

        List<?> settings = tuning.getAvailableSettings();
        List<String> options = new ArrayList<>();

        for (Object setting : settings) {
            com.jad.model.settings.MechanicalSetting ms =
                    (com.jad.model.settings.MechanicalSetting) setting;
            options.add(ms.getName() + " - " + ms.getDescription());
        }

        int choice = view.displayMenu("RÉGLAGES POUR " + tuningName.toUpperCase(), options);

        if (car.changeSetting(tuningName, choice)) {
            view.displaySuccess("Réglage modifié avec succès !");
        } else {
            view.displayError("Échec de la modification du réglage.");
        }

        view.waitForEnter();
    }

    @Override
    public void displayLog() {
        view.clear();
        String log = car.getConfigurationLog();
        view.display(log);
        view.waitForEnter();
    }
}