package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* 
Смена кодировки
*/
public class Solution  {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset utf = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        String sourceFileName = args.length < 2 ? "C:\\WorkShop\\Java\\JavaRush\\source.txt" : args[0];
        String targetFileName = args.length < 2 ? "C:\\WorkShop\\Java\\JavaRush\\target.txt" : args[1];

        FileInputStream inputStream = new FileInputStream(sourceFileName);
        FileOutputStream outputStream = new FileOutputStream(targetFileName);

        int size = inputStream.available();
        byte[] in = new byte[size];
        for (int i = 0; i < size; ++i) {
            in[i] = (byte)inputStream.read();
        }

        String line = new String(in, utf);
        byte[] out = line.getBytes(windows1251);
        outputStream.write(out);

        outputStream.close();
        inputStream.close();
    }
}
