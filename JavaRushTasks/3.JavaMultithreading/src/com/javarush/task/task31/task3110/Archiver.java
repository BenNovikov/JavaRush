package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
helps a lot:
http://www.thecoderscorner.com/team-blog/java-and-jvm/63-writing-a-zip-file-in-java-using-zipoutputstream/
*/

public class Archiver {
    private static final String helperSource = "D:/Workshop/Java/Javarush/source.txt";
    private static final String helperTarget = "D:/Workshop/Java/Javarush/source.zip";

    public static void main(String[] args) {
        String archivePathAndName = "", sourcePathAndName = "";

        try (BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)))) {
            System.out.print("Enter full path and file name of the zip archive: ");
            archivePathAndName = reader.readLine();
            if (archivePathAndName.equals("")) archivePathAndName = helperTarget;
            ZipFileManager manager = new ZipFileManager(Paths.get(archivePathAndName));

            System.out.print("Enter full path and file name of the source file: ");
            sourcePathAndName = reader.readLine();
            if (sourcePathAndName.equals("")) sourcePathAndName = helperSource;
            try {
                manager.createZip(Paths.get(sourcePathAndName));
            }
            catch (Exception e) {
            }
        }
        catch (IOException e) {
        }
    }
}
