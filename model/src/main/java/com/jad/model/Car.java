package com.jad.model;

import com.jad.model.service.AsciiComposer;
import com.jad.model.service.AsciiLoader;
import com.jad.model.tuning.*;
import com.jad.share.ICar;

import java.util.*;
import java.util.stream.Collectors;

public class Car implements ICar {

    private List<String> baseAscii;
    private Map<String, Tuning> availableTunings;

    public Car() {

        this.baseAscii = AsciiLoader.loadAsciiFile("car_base.txt");


        this.availableTunings = new LinkedHashMap<>();
        initializeTunings();
    }

    private void initializeTunings() {
        Tuning spoiler = new Spoiler();
        Tuning neon = new Neon();
        Tuning rims = new Rims();
        Tuning exhaust = new Exhaust();

        spoiler.setAsciiLines(AsciiLoader.loadAsciiFile(spoiler.getAsciiFileName()));
        neon.setAsciiLines(AsciiLoader.loadAsciiFile(neon.getAsciiFileName()));
        rims.setAsciiLines(AsciiLoader.loadAsciiFile(rims.getAsciiFileName()));
        exhaust.setAsciiLines(AsciiLoader.loadAsciiFile(exhaust.getAsciiFileName()));

        availableTunings.put(spoiler.getName(), spoiler);
        availableTunings.put(neon.getName(), neon);
        availableTunings.put(rims.getName(), rims);
        availableTunings.put(exhaust.getName(), exhaust);
    }

    @Override
    public List<String> render() {
        List<List<String>> layers = new ArrayList<>();

        layers.add(baseAscii);

        for (Tuning tuning : availableTunings.values()) {
            if (tuning.isActive()) {
                layers.add(tuning.getAsciiLines());
            }
        }

        return AsciiComposer.compose(layers);
    }

    @Override
    public boolean activateTuning(String tuningName) {
        Tuning tuning = availableTunings.get(tuningName);
        if (tuning != null) {
            tuning.setActive(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean deactivateTuning(String tuningName) {
        Tuning tuning = availableTunings.get(tuningName);
        if (tuning != null) {
            tuning.setActive(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeSetting(String tuningName, int settingIndex) {
        Tuning tuning = availableTunings.get(tuningName);
        if (tuning != null) {
            List<?> settings = tuning.getAvailableSettings();
            if (settingIndex >= 0 && settingIndex < settings.size()) {
                tuning.setSetting((com.jad.model.settings.MechanicalSetting) settings.get(settingIndex));
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getAvailableTunings() {
        return new ArrayList<>(availableTunings.keySet());
    }

    @Override
    public String getConfigurationLog() {
        StringBuilder log = new StringBuilder();

        log.append("\n=== EFFETS MÉCANIQUES ===\n");
        for (Tuning tuning : availableTunings.values()) {
            if (tuning.isActive()) {
                log.append("> ").append(tuning.getCurrentSetting().getEffect()).append("\n");
            }
        }

        log.append("\n=== CONFIGURATION ===\n");
        for (Tuning tuning : availableTunings.values()) {
            if (tuning.isActive()) {
                log.append(tuning.toString()).append("\n");
            }
        }

        return log.toString();
    }

    @Override
    public boolean isTuningActive(String tuningName) {
        Tuning tuning = availableTunings.get(tuningName);
        return tuning != null && tuning.isActive();
    }

    public Tuning getTuning(String tuningName) {
        return availableTunings.get(tuningName);
    }
}