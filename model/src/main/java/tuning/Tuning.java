package com.jad.model.tuning;

import com.jad.model.settings.MechanicalSetting;

import java.util.List;

public interface Tuning {

    List<String> render();

    String getDescription();

    MechanicalSetting getCurrentSetting();
}