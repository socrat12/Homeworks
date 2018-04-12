package home81.postgre;

import java.util.Set;
import java.util.TreeSet;

import dataBase.postgre.PostgreSQLWork;
import fileOperation.ReaderFromFile;

public class IgorDataBase {

    public static void main(String[] args) {
        insertIntoAutor();
    }

    private static void insertIntoAutor() {
        String insertAutor = "INSERT INTO t_autor(autor_name) values ('game1');";
        ReaderFromFile reader = new ReaderFromFile(IgorDataBase.class.getClassLoader().getResource("books.txt"));
        Set<String> autors = new TreeSet<>();
        
        while (reader.isReady()) {
            String autor = reader.readLine().split(";")[1];
            autors.add(autor);
        }
        
        PostgreSQLWork postgre = new PostgreSQLWork("BookShop");
        postgre.insertlistToDataBase(autors, "t_autor");
        postgre.close();
        
        System.out.println("Inserted");
    }
}
