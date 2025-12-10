package com.jad.model.tuning;

import com.jad.model.settings.ExhaustMode;

public class Exhaust extends AbstractTuning {

    public Exhaust(Tuning wrappedCar) {
        super(wrappedCar, "Pot d'Échappement", "exhaust.txt", ExhaustMode.SILENCIEUX);
    }
}