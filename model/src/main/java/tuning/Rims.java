package com.jad.model.tuning;

import com.jad.model.settings.MechanicalSetting;
import com.jad.model.settings.RimsMode;

import java.util.Arrays;
import java.util.List;

public class Rims extends AbstractTuning {

    public Rims() {
        super("Jantes", "rims.txt", RimsMode.LOW_COST);
    }

    @Override
    public List<? extends MechanicalSetting> getAvailableSettings() {
        return Arrays.asList(RimsMode.values());
    }
}