package com.jad.model.tuning;

import com.jad.model.settings.MechanicalSetting;
import com.jad.model.settings.NeonMode;

import java.util.Arrays;
import java.util.List;

public class Neon extends AbstractTuning {

    public Neon() {
        super("Néons", "neon.txt", NeonMode.SOBRE);
    }

    @Override
    public List<? extends MechanicalSetting> getAvailableSettings() {
        return Arrays.asList(NeonMode.values());
    }
}