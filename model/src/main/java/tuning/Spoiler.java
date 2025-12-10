package com.jad.model.tuning;

import com.jad.model.settings.SpoilerMode;


public class Spoiler extends AbstractTuning {

    public Spoiler(Tuning wrappedCar) {
        super(wrappedCar, "Spoiler", "spoiler.txt", SpoilerMode.ESTHETIQUE);
    }
}