package chap14.ryan;

import java.io.*;

public class ReadAFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader =
                new BufferedReader(new FileReader(new File("MyText.txt")));

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
