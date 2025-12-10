package com.jad.controller;

import com.jad.model.Car;
import com.jad.model.tuning.*;
import com.jad.share.IController;
import com.jad.view.View;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class Controller implements IController {

    private View view;
    private Tuning currentCar;
    private List<Function<Tuning, Tuning>> decorators;
    private int currentDecoratorIndex;

    public Controller() {
        this.view = new View();
        this.currentCar = new Car();
        this.currentDecoratorIndex = 0;

        view.addKeyboardListener(KeyEvent.VK_SPACE, "Proceed");

        this.decorators = new ArrayList<>();
        decorators.add(Spoiler::new);
        decorators.add(Neon::new);
        decorators.add(Rims::new);
        decorators.add(Exhaust::new);
    }

    @Override
    public void start() {
        displayCurrentCar();

        while (true) {

            waitForProceedOrQuit();

            applyNextDecorator();

            displayCurrentCar();


            view.resetAction("Proceed");
        }
    }


    private void waitForProceedOrQuit() {
        while (view.isOff("Proceed")) {

            Optional.of(view.isQuitRequested())
                    .filter(quit -> quit)
                    .ifPresent(quit -> System.exit(0));


            sleepSafely();
        }
    }


    private void sleepSafely() {
        try {
            Thread.sleep(View.WAITING_TIME);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }


    private void applyNextDecorator() {

        boolean shouldReset = currentDecoratorIndex >= decorators.size();


        Runnable[] strategies = {
                this::decorateCar,
                this::resetCar
        };


        strategies[shouldReset ? 1 : 0].run();
    }


    private void decorateCar() {
        currentCar = decorators.get(currentDecoratorIndex).apply(currentCar);
        currentDecoratorIndex++;
    }

    private void resetCar() {
        currentCar = new Car();
        currentDecoratorIndex = 0;
    }

    private void displayCurrentCar() {
        List<String> rendering = currentCar.render();
        String description = currentCar.getDescription();
        view.displayCarWithDescription(rendering, description);
    }

    @Override
    public void displayCar() {
        displayCurrentCar();
    }

    @Override
    public void manageTunings() {

    }

    @Override
    public void manageSettings() {

    }

    @Override
    public void displayLog() {
    }
}