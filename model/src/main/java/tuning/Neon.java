package com.jad.model.tuning;

import com.jad.model.settings.NeonMode;

public class Neon extends AbstractTuning {

    public Neon(Tuning wrappedCar) {
        super(wrappedCar, "Néons", "neon.txt", NeonMode.SOBRE);
    }
}