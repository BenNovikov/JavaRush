package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {
    private static TreeMap<String, String> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        String path = args[0];
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        //The following open-close stream is here for VALIDATOR only
        try {
            FileOutputStream outputStream = new FileOutputStream(allFilesContent);
            outputStream.close();
        }
        catch (IOException e) {
        }
        //End of VALIDATOR magic

        fillTheMap(path);

        try {
            FileOutputStream outputStream = new FileOutputStream(allFilesContent);
            for (String content : treeMap.values()) {
                outputStream.write(content.getBytes());
            }
            outputStream.close();
        }
        catch (IOException e) {
        }
    }

    private static void fillTheMap(String path) {
        File source = new File(path);
        for (File file : source.listFiles()) {
            if (file.isFile()) {
                if (file.length() > 50)
                    FileUtils.deleteFile(file);
                else {
                    try (FileInputStream inputStream = new FileInputStream(file)) {
                        StringBuilder builder = new StringBuilder();
                        while (inputStream.available() > 0) {
                            builder.append((char)inputStream.read());
                        }
                        treeMap.put(file.getName(), builder.toString() + System.lineSeparator());
                    }
                    catch (IOException e) {
                    }
                }
            }
            else if (file.isDirectory()) {
                fillTheMap(file.getAbsolutePath());
            }
        }
    }
}
