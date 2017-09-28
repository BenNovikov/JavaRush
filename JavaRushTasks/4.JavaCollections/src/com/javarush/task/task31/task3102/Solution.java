package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = new ArrayList<>();
        File rootFile = new File(root);
        Queue<File> fileQueue = new PriorityQueue<>();

        Collections.addAll(fileQueue, rootFile.listFiles());
        while (!fileQueue.isEmpty()) {
            File file = fileQueue.remove();
            if (file.isDirectory())
                Collections.addAll(fileQueue, file.listFiles());
            else
                fileList.add(file.getAbsolutePath());
        }

        return fileList;
    }

    public static void main(String[] args) {
        
    }
}
