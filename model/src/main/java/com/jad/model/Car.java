package com.jad.model;

import com.jad.model.service.AsciiLoader;
import com.jad.model.settings.MechanicalSetting;
import com.jad.model.tuning.Tuning;

import java.util.List;

public class Car implements Tuning {

    private List<String> baseAscii;

    public Car() {
        this.baseAscii = AsciiLoader.loadAsciiFile("car_base.txt");
    }

    @Override
    public List<String> render() {
        return baseAscii;
    }

    @Override
    public String getDescription() {
        return "Voiture de base";
    }

    @Override
    public MechanicalSetting getCurrentSetting() {
        return null;
    }
}