package activities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
public class Activity14 {

    public static void main(String[] args) {

        try {

            File myFile = new File("sample.txt");

            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(myFile);
            writer.write("Welcome to Activity14 File Handling Example.");
            writer.close();

            File fileObject = FileUtils.getFile("sample.txt");

            System.out.println("Data in file: " +
                    FileUtils.readFileToString(fileObject, "UTF8"));

            File destDir = new File("destDir");
            destDir.mkdir();

            FileUtils.copyFileToDirectory(myFile, destDir);

            System.out.println("File copied to directory successfully.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
