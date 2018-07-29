package com.itStep.home39.citiesWargaming.cities;

/**
 *  Класс, содержащий в себе атрибуты города: страна, имя, имя с прописной, 
 *  регион, население, широта, долгота
 * 
 * @author Alexander Neznaev 
 *
 */
public class City {

    private String country;
    private String name;
    private String name2;
    private byte region;
    private int population = -1;
    private double latitude;
    private double longitude;
    
    public City(String[] string) {
	if (string.length != 7) {
	    return;
	}
	country = string[0];
	name = string[1];
	name2 = string[2];
	region = Byte.parseByte(string[3]);
	if (string[4].length() != 0) population = Integer.parseInt(string[4]);
	latitude = Double.parseDouble(string[5]);
	longitude = Double.parseDouble(string[6]);
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getName2() {
        return name2;
    }

    public byte getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
	String s = country + ",";
	s += name + ",";
	s += name2 + ",";
	s += region + ",";
	s += population + ",";
	s += latitude + ",";
	s += longitude + "\r\n";
	return s;
    }
    
}
