package dao;

import java.io.*;

public class FileIO {

    public void printFileInLocal(File file ,String text) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write(text , 0 , text.length());
        writer.close();
    }

}
