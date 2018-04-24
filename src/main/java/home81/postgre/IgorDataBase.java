package home81.postgre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import dataBase.postgre.PostgreSQLWork;
import fileOperation.ReaderFromFile;
import listCreators.NamesAndWords;

public class IgorDataBase {

    private static List<List<String>> books = new ArrayList<>();

    public static void main(String[] args) {
        insertIntoAutor();
        insertIntoBooks();
        insertIntoUserGroup();
        insertIntoUsers();
    }

    private static void insertIntoUsers() {
        List<String> lastNames = NamesAndWords.englishLastNames();
        List<String> manNames = NamesAndWords.englishManNames();
        List<String> manNickNames = NamesAndWords.englishManNickNames();
        List<String> womanNames = NamesAndWords.englishWomanNames();
        List<String> womanNickNames = NamesAndWords.englishWomanNickNames();
        List<String> cities = NamesAndWords.belorussianCities();

        List<List<String>> group = new ArrayList<>();
        PostgreSQLWork postgre = new PostgreSQLWork(Attributes.BASE_NAME);
        int amount = manNickNames.size() + womanNickNames.size();

        for (int i = 0; i < amount; i++) {
            ArrayList<String> toAdd = fillingUser(lastNames, manNames, manNickNames, womanNames, womanNickNames, cities,
                    postgre);
            group.add(toAdd);
        }

        postgre.insertlistToDataBase(group, "t_user");
        postgre.close();
        System.out.println("t_user filled");
    }

    private static ArrayList<String> fillingUser(List<String> lastNames, List<String> manNames,
            List<String> manNickNames, List<String> womanNames, List<String> womanNickNames, List<String> cities,
            PostgreSQLWork postgre) {
        ArrayList<String> toAdd = new ArrayList<String>();

        // nickname
        String nickname = "";
        boolean random;
        random = Math.random() < 0.5;
        if (random && !manNickNames.isEmpty()) {
            nickname = nicknameFinder(manNickNames);
        } else {
            if (!womanNickNames.isEmpty()) {
                nickname = nicknameFinder(womanNickNames);
            } else {
                nickname = nicknameFinder(manNickNames);
                random = true;
            }
        }
        // name
        if (random)
            toAdd.add(manNames.get((int) (Math.random() * manNames.size())));
        else
            toAdd.add(womanNames.get((int) (Math.random() * womanNames.size())));

        // last name
        toAdd.add(lastNames.get((int) (Math.random() * lastNames.size())));

        // nickname
        toAdd.add(nickname);

        // password
        toAdd.add(randomPassword());

        // address
        toAdd.add(cities.get((int) (Math.random() * cities.size())));

        // birth date
        toAdd.add(randomBirthDate());

        List<List<String>> user_group = postgre.executeCustomQuery(Attributes.SELECT_USER_GROUP);
        toAdd.add(user_group.get(randomIndex()).get(0));
        return toAdd;
    }

    private static String nicknameFinder(List<String> nickNames) {
        String nickname;
        int index = (int) (Math.random() * nickNames.size());
        nickname = nickNames.get(index);
        nickNames.remove(index);
        return nickname;
    }

    private static int randomIndex() {
        double random = Math.random();
        if (random > 0.9)
            return 1;
        if (random < 0.2)
            return 0;
        else
            return 2;
    }

    private static String randomBirthDate() {
        long mills = (long) (Math.random() * (Math.random() < 0.5 ? 1 : -0.2) * 1262296800000L);
        Date date = new Date(mills);
        String format = Attributes.dateFormat.format(date);
        return format;
    }

    private static String randomPassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < (int) (Math.random() * 5 + 10); i++) {
            String toAppend = "";
            double random = Math.random();
            if (random < 0.34)
                toAppend = (char) (Math.random() * 26 + 'A') + "";
            else if (random > 0.33 && random < 0.67)
                toAppend = (char) (Math.random() * 26 + 'a') + "";
            else
                toAppend = (char) (Math.random() * 10 + '0') + "";
            password.append(toAppend);
        }
        return password.toString();
    }

    private static void insertIntoUserGroup() {
        List<List<String>> groupName = new ArrayList<>();

        PostgreSQLWork postgre = new PostgreSQLWork(Attributes.BASE_NAME);
        for (int i = 0; i < Attributes.groups.length; i++) {
            ArrayList<String> toAdd = new ArrayList<String>();
            toAdd.add(Attributes.groups[i]);
            groupName.add(toAdd);
        }
        postgre.insertlistToDataBase(groupName, "t_user_group");
        postgre.close();
        System.out.println("t_user_group filled");
    }

    private static void insertIntoAutor() {
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

    private static void insertIntoBooks() {
        List<List<String>> booksToQuery = new ArrayList<>();
        PostgreSQLWork postgre = new PostgreSQLWork(Attributes.BASE_NAME);

        for (List<String> book : books) {
            List<List<String>> autors = postgre.executeCustomQuery(Attributes.SELECT_AUTORS);
            List<String> currentBook = fillingBook(book, autors);
            booksToQuery.add(currentBook);
        }
        postgre.insertlistToDataBase(booksToQuery, "t_book");
        postgre.close();
        System.out.println("t_book filled");
    }

    private static List<String> fillingBook(List<String> book, List<List<String>> autors) {
        List<String> currentBook = new ArrayList<>();
        // title
        currentBook.add(book.get(2));

        String autorID = findId(book.get(1), autors);
        currentBook.add(autorID);

        // date
        if (book.size() == 4)
            currentBook.add(book.get(3));
        else
            currentBook.add("");

        String categ = Attributes.category[(int) (Math.random() * Attributes.category.length)];
        currentBook.add(categ);

        String price = (int) ((Math.random() * 200 + 10) * 100) / 100.0 + "";
        currentBook.add(price);

        String amount = (int) (Math.random() * 990 + 10) + "";
        currentBook.add(amount);
        return currentBook;
    }

    private static String findId(String string, List<List<String>> autors) {
        for (int i = 0; i < autors.size(); i++) {
            if (string != null && string.equals(autors.get(i).get(1)))
                return autors.get(i).get(0) + "";
        }
        return null;
    }
}
