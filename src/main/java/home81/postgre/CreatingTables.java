package home81.postgre;

import java.io.File;

import dataBase.postgre.PostgreSQLWork;
import fileOperation.ReaderFromFile;

public class CreatingTables {

    public static void main (String[] args) {
        PostgreSQLWork postgre = new PostgreSQLWork(Attributes.BASE_NAME);
        
        postgre.customQuery(Attributes.DELETE_SCHEMA);
        postgre.customQuery(Attributes.CREATE_SCHEMA);
        
        File[] folder = new File(Attributes.PATH).listFiles();
        for (File file : folder) {
            createTable(postgre, file);
        }

        postgre.close();
        System.out.println("Done");
    }

    private static void createTable (PostgreSQLWork postgre, File file) {
        ReaderFromFile reader = new ReaderFromFile(file);
        String query = reader.readAll();
        postgre.customQuery(query);
        reader.close();
    }
}
