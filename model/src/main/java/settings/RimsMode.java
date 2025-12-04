package com.jad.model.settings;

public enum RimsMode implements MechanicalSetting {

    PERFORMANCE("Performance", "Accélération améliorée", "Jantes légères en alliage"),
    LOW_COST("Low-cost", "Aucun effet", "Jantes standard économiques"),
    SHOW_OFF("Show-off", "Bruit distinctif", "Jantes chromées voyantes");

    private final String name;
    private final String effect;
    private final String description;

    RimsMode(String name, String effect, String description) {
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