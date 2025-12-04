package com.jad.share;

import java.util.List;

public interface ICar {

    List<String> render();

    boolean activateTuning(String tuningName);

    boolean deactivateTuning(String tuningName);

    boolean changeSetting(String tuningName, int settingIndex);

    List<String> getAvailableTunings();

    String getConfigurationLog();

    boolean isTuningActive(String tuningName);
}