package home81.postgre;

import java.text.SimpleDateFormat;

public class Attributes {

    public static final String CREATE_SCHEMA = "CREATE SCHEMA public;";
    public static final String DELETE_SCHEMA = "DROP SCHEMA public CASCADE;";
    public static final String BASE_NAME = "BookShop";
    public static final String PATH = ".\\src\\main\\java\\home81\\postgre\\sql\\";
    public static final String SELECT_AUTORS = "SELECT * from t_autor;";
    public static final String SELECT_USER_GROUP = "SELECT * from t_user_group;";
    public static String[] category = { "Басня", "Гимн", "Водевиль", "Былина", "Инвектива", "Драма", "Легенда",
            "Мадригал", "Комедия", "Новелла", "Ода", "Мелодрама", "Очерк", "Скетч", "Повесть", "Послание", "Трагедия",
            "Рассказ", "Романс", "Роман", "Сонет", "Сказка", "Стансы", "Эпопея" };
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static String[] groups = { "administrators", "developer", "users" };
    
}
