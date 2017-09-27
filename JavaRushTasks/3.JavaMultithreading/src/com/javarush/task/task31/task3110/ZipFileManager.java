package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        Path parentDirectory = zipFile.getParent();
        if (Files.notExists(parentDirectory))
            Files.createDirectory(parentDirectory);

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            }
            else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path entry : fileNames)
                    addNewZipEntry(zipOutputStream, source, entry);
            }
            else throw new PathIsNotFoundException();
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path source = filePath.resolve(fileName);
        String name = fileName.toString();
        ZipEntry entry = new ZipEntry(name);
        zipOutputStream.putNextEntry(entry);
        try (InputStream inputStream = Files.newInputStream(source) ) {
            copyData(inputStream, zipOutputStream);
        }
        zipOutputStream.closeEntry();
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        while (in.available() > 0)
            out.write(in.read());
    }
}
