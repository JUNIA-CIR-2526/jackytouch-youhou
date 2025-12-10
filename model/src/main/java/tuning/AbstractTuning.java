package com.jad.model.tuning;

import com.jad.model.service.AsciiComposer;
import com.jad.model.service.AsciiLoader;
import com.jad.model.settings.MechanicalSetting;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractTuning implements Tuning {

    protected Tuning wrappedCar;
    protected String name;
    protected String asciiFileName;
    protected MechanicalSetting currentSetting;


    public AbstractTuning(Tuning wrappedCar, String name, String asciiFileName, MechanicalSetting defaultSetting) {
        this.wrappedCar = wrappedCar;
        this.name = name;
        this.asciiFileName = asciiFileName;
        this.currentSetting = defaultSetting;
    }

    @Override
    public List<String> render() {

        List<String> baseRender = wrappedCar.render();


        List<String> tuningLayer = AsciiLoader.loadAsciiFile(asciiFileName);


        return AsciiComposer.compose(Arrays.asList(baseRender, tuningLayer));
    }

    @Override
    public String getDescription() {

        String baseDescription = wrappedCar.getDescription();
        return baseDescription + "\n  + " + name + " " + currentSetting.getName() +
                " : " + currentSetting.getEffect();
    }

    @Override
    public MechanicalSetting getCurrentSetting() {
        return currentSetting;
    }
}