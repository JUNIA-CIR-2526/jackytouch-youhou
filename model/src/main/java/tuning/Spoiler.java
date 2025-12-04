package com.jad.model.tuning;

import com.jad.model.settings.MechanicalSetting;
import com.jad.model.settings.SpoilerMode;

import java.util.Arrays;
import java.util.List;

public class Spoiler extends AbstractTuning {

    public Spoiler() {
        super("Spoiler", "spoiler.txt", SpoilerMode.ESTHETIQUE);
    }

    @Override
    public List<? extends MechanicalSetting> getAvailableSettings() {
        return Arrays.asList(SpoilerMode.values());
    }
}