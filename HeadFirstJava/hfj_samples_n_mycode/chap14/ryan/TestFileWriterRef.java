package chap14.ryan;

import java.io.*;

public class TestFileWriterRef {
    public static void main(String[] args) throws IOException {
        try {
            FileWriter fw = new FileWriter("aaa.txt");
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("This is my first question:\n");
            writer.write("What does Quiz Card Builder do?\n");
            writer.close();
            fw.write("Thefistfive characters.", 3, 5);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
