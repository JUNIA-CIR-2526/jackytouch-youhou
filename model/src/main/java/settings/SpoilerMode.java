package com.jad.model.settings;

public enum SpoilerMode implements MechanicalSetting {

    ESTHETIQUE("Esthétique", "Aucun effet mécanique", "Spoiler purement décoratif"),
    AERODYNAMIQUE("Aérodynamique", "Stabilité accrue", "Améliore l'adhérence à haute vitesse"),
    EXAGERE("Exagéré", "Vitesse max réduite, effet visuel accentué", "Spoiler surdimensionné pour le show");

    private final String name;
    private final String effect;
    private final String description;

    SpoilerMode(String name, String effect, String description) {
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