package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        String fileIn = "", fileOut = "";

        try (BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)))) {
            System.out.print("Enter the full path and the file name of the archive(target): ");
            fileIn = reader.readLine();

            Path path = Paths.get(fileIn);
            ZipFileManager manager = new ZipFileManager(path);

            System.out.print("Enter the full path and the file name of the archived(source) file: ");
            fileOut = reader.readLine();
            path = Paths.get(fileOut);
            try {
                manager.createZip(path);
            }
            catch (Exception e) {
            }
        }
        catch (IOException e) {
        }
    }
}
