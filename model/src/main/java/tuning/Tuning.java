package com.jad.model.tuning;

import com.jad.model.settings.MechanicalSetting;

import java.util.List;
public interface Tuning {
    String getName();
    String getAsciiFileName();
    MechanicalSetting getCurrentSetting();
    void setSetting(MechanicalSetting setting);

    List<? extends MechanicalSetting> getAvailableSettings();

    boolean isActive();

    void setActive(boolean active);

    List<String> getAsciiLines();

    void setAsciiLines(List<String> lines);
}