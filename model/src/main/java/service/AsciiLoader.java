package com.jad.model.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AsciiLoader {

    private static final String RESOURCE_PATH = "/ressources/";
    public static List<String> loadAsciiFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try (InputStream is = AsciiLoader.class.getResourceAsStream(RESOURCE_PATH + fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            if (is == null) {
                throw new RuntimeException("Fichier non trouvé : " + RESOURCE_PATH + fileName);
            }

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du chargement du fichier " + fileName + " : " + e.getMessage(), e);
        }

        return lines;
    }
}