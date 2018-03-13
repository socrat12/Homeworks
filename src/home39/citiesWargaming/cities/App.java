package home39.citiesWargaming.cities;

import java.util.ArrayList;

import home39.citiesWargaming.cities.utils.IOoperations;

/**
 * @author Neznaev_AI
 *
 */
public class App {
    
    /**
     *  Средний радиус Земли
     */
    private final static int EARTH_RADIUS = 6371;
    private final static String NEW_FILE_PATH = "resources\\cities\\citiesWithPopulation.txt";
    private static ArrayList<City> cities;
    private static IOoperations io;
    
    public static void main(String[] args) {
	io = new IOoperations();
	cities = io.getArray();

	showCitiesWithSpecificPopulation("by", 50000);
	showCitiesWithSpecificPopulation(1000000);

	citiesWithPopulationToANewFile();

	distanceBetweenNorthernAndSouthernCity();
	
	io.closeFiles();
    }

    /**
     *  Расстояние от самого северного до самого южного города, содержащегося в ArrayList <b>cities</b>
     */
    private static void distanceBetweenNorthernAndSouthernCity() {
	int min = 0;
	int max = 0;
	for (int i = 1; i < cities.size(); i++) {
	    if (cities.get(i).getLatitude() < cities.get(min).getLatitude()) {
		min = i;
	    }
	    if (cities.get(i).getLatitude() > cities.get(max).getLatitude()) {
		max = i;
	    }
	}

	double fiA = cities.get(min).getLatitude();
	double fiB = cities.get(max).getLatitude();
	double lambdA = cities.get(min).getLongitude();
	double lambdB = cities.get(max).getLongitude();

	double cosD = Math.sin(fiA) * Math.sin(fiB) + Math.cos(fiA) * Math.cos(fiB) * Math.cos(lambdA - lambdB);

	double distance = Math.acos(cosD) * EARTH_RADIUS;

	System.out.println(distance);
    }

    /**
     *  Отсев городов с заполненной графой <b>население</b> в отдельный файл
     */
    private static void citiesWithPopulationToANewFile() {
	io.createNewFile(NEW_FILE_PATH);
	for (City c : cities) {
	    if (c.getPopulation() > 0) {
		io.writeLine(c.toString());
	    }
	}
    }
    
    /** Вывод городов с количеством населения, превыщающим указанное <br> в параметре <b>population</b>
     *  Города могут быть любой страны, из тех, <br>что присутствуют в <b>cities</b>
     *  
     * @param population int-значение соответствующее количеству населения
     */
    private static void showCitiesWithSpecificPopulation (int population) {
	showCitiesWithSpecificPopulation (null, population);
    }

    /**
     *  Вывод городов с количеством населения, превыщающим указанное <br> в параметре <b>population</b>
     *  Города принадлежат стране, указанной в параметре <br><b>country</b>
     * 
     * @param country String в виде сокращенного буквенного кода страны
     * @param population int-значение соответствующее количеству населения
     */
    private static void showCitiesWithSpecificPopulation(String country, int population) {
	if (country == null) {
	    // регулярное выражение - любой символ
	    country = ".+";
	}
	int count = 1;
	for (City c : cities) {
	    if (c.getCountry() != null && c.getCountry().matches(country) && c.getPopulation() > population) {
		System.out.println(count++ + ". " + c.getName2());
	    }
	}
    }
}