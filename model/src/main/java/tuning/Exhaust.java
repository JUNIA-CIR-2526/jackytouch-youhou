package com.jad.model.tuning;

import com.jad.model.settings.MechanicalSetting;
import com.jad.model.settings.ExhaustMode;

import java.util.Arrays;
import java.util.List;

public class Exhaust extends AbstractTuning {

    public Exhaust() {
        super("Pot d'Échappement", "exhaust.txt", ExhaustMode.SILENCIEUX);
    }

    @Override
    public List<? extends MechanicalSetting> getAvailableSettings() {
        return Arrays.asList(ExhaustMode.values());
    }
}