package dao;

import java.io.*;

public class FileIO {

    public void printFileInLocal(File file ,String text) throws IOException {
//        FileWriter fileWriter = new FileWriter(file);
//        fileWriter.write(text);
//        fileWriter.close();
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
        System.out.println(text);
        writer.write(text , 0 , text.length());
        writer.close();
    }

}
