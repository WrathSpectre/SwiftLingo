package com.wrathspectre.test_11;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static final String directoryPath = Environment.getExternalStorageDirectory().toString();
    private File topicFile;

    private static FileManager instance = new FileManager();

    private FileManager() {
        File directory = new File(directoryPath, "/SwiftLingo");

        if(!directory.exists()) {
            directory.mkdirs();

         topicFile = new File(directoryPath, "/SwiftLingo/topicFile.txt");
         if(directory.exists()) System.out.println("YWVDYVDYDVYDVYDVYDVYDVYD");
         else {
             System.out.println("000000000000000000000000000000000000000000000000000000");
         }
        }
    }

    public static synchronized FileManager getInstance() {
       if(instance == null) {
           instance = new FileManager();
       }

       return instance;
    }

    void saveTopic() {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(topicFile));
            printStream.println("Hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<String> getTopics() {
        List<String> data = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(topicFile));

            String line = reader.readLine();
            while(line != null) {
                data.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
