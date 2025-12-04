package com.jad.model.settings;

public enum ExhaustMode implements MechanicalSetting {

    SILENCIEUX("Silencieux", "Bruit discret", "Échappement furtif"),
    SPORT("Sport", "Bruit puissant", "Sonorité sportive agressive"),
    DRAG("Drag", "Bruit extrême", "Rugissement de compétition");

    private final String name;
    private final String effect;
    private final String description;

    ExhaustMode(String name, String effect, String description) {
        this.name = name;
        this.effect = effect;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEffect() {
        return effect;
    }

    @Override
    public String getDescription() {
        return description;
    }
}