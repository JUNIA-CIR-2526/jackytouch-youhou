package com.jad.model.settings;


public enum NeonMode implements MechanicalSetting {

    SOBRE("Sobre", "Lumière fixe", "Éclairage constant et discret"),
    DISCO("Disco", "Clignotement simulé", "Effets lumineux rythmés"),
    ALEATOIRE("Aléatoire", "Affichage imprévisible", "Séquence lumineuse chaotique");

    private final String name;
    private final String effect;
    private final String description;

    NeonMode(String name, String effect, String description) {
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