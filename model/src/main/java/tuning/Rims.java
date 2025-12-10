package com.jad.model.tuning;

import com.jad.model.settings.RimsMode;

public class Rims extends AbstractTuning {

    public Rims(Tuning wrappedCar) {
        super(wrappedCar, "Jantes", "rims.txt", RimsMode.LOW_COST);
    }
}