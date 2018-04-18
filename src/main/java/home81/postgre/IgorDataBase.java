package home81.postgre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import dataBase.postgre.PostgreSQLWork;
import fileOperation.ReaderFromFile;

public class IgorDataBase {

    private static List<List<String>> books = new ArrayList<>();
    private static String[] category = { "Басня", "Гимн", "Водевиль", "Былина", "Инвектива", "Драма", "Легенда",
            "Мадригал", "Комедия", "Новелла", "Ода", "Мелодрама", "Очерк", "Скетч", "Повесть", "Послание", "Трагедия",
            "Рассказ", "Романс", "Роман", "Сонет", "Сказка", "Стансы", "Эпопея" };

    public static void main (String[] args) {
        /*insertIntoAutor();
        insertIntoBooks();
        insertIntoUserGroup();*/
        insertIntoUsers();
    }

    private static void insertIntoUsers () {
        ReaderFromFile reader = new ReaderFromFile(PostgreSQLWork.class.getClassLoader().getResource("EngLastNames.txt"));
        List<String> lastNames = reader.readAllAsLIst();
        
        List<List<String>> groupName = new ArrayList<>();

        PostgreSQLWork postgre = new PostgreSQLWork(Attributes.BASE_NAME);
        for (int i = 0; i < 15; i++) {
            ArrayList<String> toAdd = new ArrayList<String>();
            toAdd.add(lastNames.get((int) (Math.random() * lastNames.size())));
            groupName.add(toAdd);
        }
        
        postgre.insertlistToDataBase(groupName, "t_user");
        postgre.close();
        System.out.println("t_user filled");
    }

    private static void insertIntoUserGroup () {
        ReaderFromFile reader = new ReaderFromFile(PostgreSQLWork.class.getClassLoader().getResource("EngWoman.txt"));
        List<String> names = reader.readAllAsLIst();
        List<List<String>> groupName = new ArrayList<>();

        PostgreSQLWork postgre = new PostgreSQLWork(Attributes.BASE_NAME);
        for (int i = 0; i < 15; i++) {
            ArrayList<String> toAdd = new ArrayList<String>();
            toAdd.add(names.get((int) (Math.random() * names.size())));
            groupName.add(toAdd);
        }
        postgre.insertlistToDataBase(groupName, "t_user_group");
        postgre.close();
        System.out.println("t_user_group filled");
    }

    private static void insertIntoAutor () {
        ReaderFromFile reader = new ReaderFromFile(".\\src\\main\\resources\\IgorDataBase\\books.txt");
        Set<String> autors = new TreeSet<>();
        List<List<String>> autorsAsList = new ArrayList<>();

        while (reader.isReady()) {
            String[] line = reader.readLine().split(";");
            List<String> lineAsList = Arrays.asList(line);
            books.add(lineAsList);
            String autor = lineAsList.get(1);

            if (autors.add(autor)) {
                List<String> temp = new ArrayList<String>();
                temp.add(autor);
                autorsAsList.add(temp);
            }
        }
        reader.close();

        PostgreSQLWork postgre = new PostgreSQLWork(Attributes.BASE_NAME);
        postgre.insertlistToDataBase(autorsAsList, "t_autor");
        postgre.close();

        System.out.println("t_autor filled");
    }

    private static void insertIntoBooks () {
        List<List<String>> booksToQuery = new ArrayList<>();
        PostgreSQLWork postgre = new PostgreSQLWork(Attributes.BASE_NAME);

        for (List<String> book : books) {
            List<List<String>> autors = postgre.executeCustomQuery(Attributes.SELECT_AUTORS);
            List<String> currentBook = new ArrayList<>();

            filling(book, autors, currentBook);
            booksToQuery.add(currentBook);
        }
        postgre.insertlistToDataBase(booksToQuery, "t_book");
        postgre.close();
        System.out.println("t_book filled");
    }

    private static void filling (List<String> book, List<List<String>> autors, List<String> currentBook) {
        // title
        currentBook.add(book.get(2));

        String autorID = findId(book.get(1), autors);
        currentBook.add(autorID);

        // date
        if (book.size() == 4) currentBook.add(book.get(3));
        else currentBook.add("");

        String categ = category[(int) (Math.random() * category.length)];
        currentBook.add(categ);

        String price = (int) ((Math.random() * 200 + 10) * 100) / 100.0 + "";
        currentBook.add(price);

        String amount = (int) (Math.random() * 990 + 10) + "";
        currentBook.add(amount);
    }

    private static String findId (String string, List<List<String>> autors) {
        for (int i = 0; i < autors.size(); i++) {
            if (string != null && string.equals(autors.get(i).get(1))) return autors.get(i).get(0) + "";
        }
        return null;
    }
}
