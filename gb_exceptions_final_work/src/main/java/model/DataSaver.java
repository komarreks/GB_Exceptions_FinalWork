package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataSaver {
    public static void saveData(String[] data) throws IOException {
        String path = "src/files/"+data[0];

        File fileDirectory = new File("src/files/");
        if (!fileDirectory.exists()){
            fileDirectory.mkdir();
        }

        File file = new File(path);

        if (!file.exists()){
            file.createNewFile();
        }

        try (FileWriter fw = new FileWriter(file, true);){
            fw.write(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4] + " " + data[5] + "\n");
            fw.flush();
        }
    }

}
