package com.jad.model.tuning;

import com.jad.model.settings.MechanicalSetting;

import java.util.List;

public abstract class AbstractTuning implements Tuning {

    protected String name;
    protected String asciiFileName;
    protected MechanicalSetting currentSetting;
    protected boolean active;
    protected List<String> asciiLines;

    public AbstractTuning(String name, String asciiFileName, MechanicalSetting defaultSetting) {
        this.name = name;
        this.asciiFileName = asciiFileName;
        this.currentSetting = defaultSetting;
        this.active = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAsciiFileName() {
        return asciiFileName;
    }

    @Override
    public MechanicalSetting getCurrentSetting() {
        return currentSetting;
    }

    @Override
    public void setSetting(MechanicalSetting setting) {
        this.currentSetting = setting;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public List<String> getAsciiLines() {
        return asciiLines;
    }

    @Override
    public void setAsciiLines(List<String> lines) {
        this.asciiLines = lines;
    }

    @Override
    public String toString() {
        return String.format("| %s %s", currentSetting.getName(), name);
    }
}