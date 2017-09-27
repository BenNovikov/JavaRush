package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/*
helps a lot:
http://www.thecoderscorner.com/team-blog/java-and-jvm/63-writing-a-zip-file-in-java-using-zipoutputstream/
*/

public class Archiver {
    private static final String helperSource = "D:/Workshop/Java/Javarush/source.txt";
    private static final String helperTarget = "D:/Workshop/Java/Javarush/source.zip";

    public static void main(String[] args) {
//        String archivePathAndName = "", sourcePathAndName = "";
//
//        try (BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)))) {
//            System.out.print("Enter full path and file name of the zip archive: ");
//            archivePathAndName = reader.readLine();
//            if (archivePathAndName.equals("")) archivePathAndName = helperTarget;
//            ZipFileManager manager = new ZipFileManager(Paths.get(archivePathAndName));
//
//            System.out.print("Enter full path and file name of the source file: ");
//            sourcePathAndName = reader.readLine();
//            if (sourcePathAndName.equals("")) sourcePathAndName = helperSource;
//            try {
//                manager.createZip(Paths.get(sourcePathAndName));
//            }
//            catch (Exception e) {
//            }
//        }
//        catch (IOException e) {
//        }

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            }
            catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            }
            catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(String.format("\t %d - упаковать файлы в архив", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - добавить файл в архив", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - удалить файл из архива", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - распаковать архив", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - просмотреть содержимое архива", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - выход", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}
