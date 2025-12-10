package com.jad.view;

import com.jad.share.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class View implements IView {

    public static final int WAITING_TIME = 50;

    private JFrame frame;
    private JTextArea textArea;
    private Map<String, Boolean> actionStates;
    private Map<Integer, Runnable> keyActions;

    public View() {
        this.actionStates = new HashMap<>();
        this.keyActions = new HashMap<>();
        initializeWindow();
    }

    private void initializeWindow() {
        frame = new JFrame("JackyTouch Tuning");
        textArea = new JTextArea(20, 60);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(false);
        textArea.setFocusable(true);

        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        actionStates.put("Proceed", false);
        actionStates.put("Quit", false);

        textArea.requestFocusInWindow();
    }


    public void addKeyboardListener(int keyCode, String action) {

        keyActions.put(keyCode, () -> actionStates.put(action, true));


        keyActions.put(KeyEvent.VK_ESCAPE, () -> actionStates.put("Quit", true));

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                Optional.ofNullable(keyActions.get(e.getKeyCode()))
                        .ifPresent(Runnable::run);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
    }


    public boolean isOff(String action) {
        return !actionStates.getOrDefault(action, false);
    }


    public void resetAction(String action) {
        actionStates.put(action, false);
    }


    public void waitForAction(String action) {
        while (isOff(action)) {
            try {
                Thread.sleep(WAITING_TIME);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }


    public boolean isQuitRequested() {
        return actionStates.getOrDefault("Quit", false);
    }

    @Override
    public void display(String message) {
        textArea.setText(message);
    }

    @Override
    public void displayCar(List<String> asciiLines) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        asciiLines.forEach(line -> sb.append(line).append("\n"));
        textArea.setText(sb.toString());
    }

    public void displayCarWithDescription(List<String> asciiLines, String description) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== JACKYTOUCH TUNING ===\n\n");
        asciiLines.forEach(line -> sb.append(line).append("\n"));
        sb.append("\n").append(description).append("\n");
        textArea.setText(sb.toString());
    }

    @Override
    public int displayMenu(String title, List<String> options) {
        return 0;
    }

    @Override
    public String readInput(String prompt) {
        return "";
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        return 0;
    }

    @Override
    public void clear() {
        textArea.setText("");
    }
}