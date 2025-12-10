package com.jad.model.service;

import java.util.ArrayList;
import java.util.List;

public class AsciiComposer {

    public static List<String> compose(List<List<String>> layers) {
        if (layers == null || layers.isEmpty()) {
            return new ArrayList<>();
        }


        int maxWidth = 0;
        for (List<String> layer : layers) {
            for (String line : layer) {
                maxWidth = Math.max(maxWidth, line.length());
            }
        }


        List<List<String>> normalizedLayers = new ArrayList<>();
        for (List<String> layer : layers) {
            normalizedLayers.add(normalizeLinesWidth(layer, maxWidth));
        }


        List<String> result = new ArrayList<>(normalizedLayers.get(0));


        for (int layerIndex = 1; layerIndex < normalizedLayers.size(); layerIndex++) {
            List<String> currentLayer = normalizedLayers.get(layerIndex);
            result = overlayLayer(result, currentLayer);
        }

        return result;
    }


    private static List<String> normalizeLinesWidth(List<String> lines, int width) {
        List<String> normalized = new ArrayList<>();
        for (String line : lines) {
            if (line.length() < width) {

                normalized.add(line + " ".repeat(width - line.length()));
            } else if (line.length() > width) {

                normalized.add(line.substring(0, width));
            } else {
                normalized.add(line);
            }
        }
        return normalized;
    }


    private static List<String> overlayLayer(List<String> base, List<String> overlay) {
        List<String> result = new ArrayList<>();

        int maxLines = Math.max(base.size(), overlay.size());

        for (int i = 0; i < maxLines; i++) {
            String baseLine = i < base.size() ? base.get(i) : "";
            String overlayLine = i < overlay.size() ? overlay.get(i) : "";

            result.add(mergeLine(baseLine, overlayLine));
        }

        return result;
    }

    private static String mergeLine(String baseLine, String overlayLine) {
        StringBuilder result = new StringBuilder();

        int maxLength = Math.max(baseLine.length(), overlayLine.length());

        for (int i = 0; i < maxLength; i++) {
            char baseChar = i < baseLine.length() ? baseLine.charAt(i) : ' ';
            char overlayChar = i < overlayLine.length() ? overlayLine.charAt(i) : ' ';


            if (isTransparent(overlayChar)) {
                result.append(baseChar);
            } else {

                result.append(overlayChar);
            }
        }

        return result.toString();
    }


    private static boolean isTransparent(char c) {
        return c == ' ' || c == '.';
    }
}