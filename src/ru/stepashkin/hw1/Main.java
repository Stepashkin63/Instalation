package ru.stepashkin.hw1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static String rootDir = "H:/Games/";

    public static void main(String[] args) {

        createDir("src");
        createDir("res");
        createDir("savegames");
        createDir("temp");
        createDir("src/main");
        createDir("src/test");
        createDir("res/icons");
        createDir("res/vectors");
        createDir("res/drawables");
        createFile("src/main/Main.java");
        createFile("src/main/Utils.java");
        createFile("temp/temp.txt");

        try (FileWriter writer = new FileWriter(rootDir + "temp/temp.txt")) {
            writer.write(log.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static StringBuilder log = new StringBuilder();

    static void createDir(String name) {
        File dir = new File(rootDir + name);
        log
                .append(logResult(dir.mkdir(), dir, name))
                .append("\n");
    }

    static void createFile(String name) {
        File file = new File(rootDir + name);
        try {
            log
                    .append(logResult(file.createNewFile(), file, name))
                    .append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static String logResult(boolean ready, File type, String name) {
        if (type.isDirectory()) {
            return ready ? "Каталог " + name + " создан" : "Каталог " + name + " не создан";
        } else {
            return ready ? "Файл " + name + " создан" : "Файл " + name + " не создан";
        }
    }
}
