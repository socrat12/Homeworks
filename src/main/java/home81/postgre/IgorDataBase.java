package home81.postgre;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import dataBase.postgre.PostgreSQLWork;
import fileOperation.ReaderFromFile;

public class IgorDataBase {

    public static void main(String[] args) {
        insertIntoAutor();
    }

    private static void insertIntoAutor() {
        ReaderFromFile reader = new ReaderFromFile(IgorDataBase.class.getClassLoader().getResource("books.txt"));
        Set<String> autors = new TreeSet<>();
        
        while (reader.isReady()) {
            String autor = reader.readLine().split(";")[1];
            autors.add(autor);
        }
        
        List<List<String>> autorsAsList = new ArrayList<>();
        autorsAsList.add(new ArrayList<String>(autors));
        
        PostgreSQLWork postgre = new PostgreSQLWork("BookShop");
        postgre.insertlistToDataBase(autorsAsList, "t_autor");
        postgre.close();
        
        System.out.println("Inserted");
    }
}
