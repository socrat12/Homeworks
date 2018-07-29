package com.itStep.home04.square;
//1. Обнулить последние i бит числа А. А - переменная типа int
//2. Установить i-ый бит (первый - самый правый) числа A равным 1
public class offset {

    public static void main(String[] args) {
	int a = 255, b = 15, i1 = 5, i2 = 8;

	a = (a >> i1) << i1;

	System.out.println(a);

	b |= (1 << i2 - 1);

	System.out.println(b);
	
	System.out.println("fuckon".replaceAll("on", "off"));
    }
}
