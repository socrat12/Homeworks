package com.itStep.home41.amazon.tree;

/**
 * Тестовое задание амазона 2.
 *
 * В метод передается массив целых чисел и 2 индекса для этого же массива.
 * Создать бинарное дерево поиска из этих чисел (добавляя элементы в самописное
 * дерево том же порядке, что и в массиве) и найти расстояние между элементами с
 * соответствующими индексами в получившемся дереве. Расстояние - это количество
 * ребер между этими двумя узлами дерева.
 */

public class Arrays {

    public static void main(String[] args) {
	int[] values = { 17, 14, 29, 20, 27, 23, 22, 21, 28, 18, 15, 3, 12, 10, 0 };

	// int[] values = new int[20];
	// for (int i = 0; i < values.length; i++) {
	// values[i] = (int) (Math.random() * 90);
	// }

	// System.out.println(values[8] + " " + values[12]);

	int distance = findDistance(values, 8, 12);
	System.out.println(distance);

	distance = findDistance2(values, 8, 12);
	System.out.println(distance);
    }

    public static int findDistance(int[] values, int node1, int node2) {
	Tree fromArray = new Tree();
	for (int i : values) {
	    fromArray.add(i);
	}
	// System.out.println(fromArray);
	int d = fromArray.findDistance(values[node1], values[node2]);
	return d;
    }

    public static int findDistance2(int[] values, int node1, int node2) {
	Tree fromArray = new Tree2();
	for (int i : values) {
	    fromArray.add(i);
	}
	// System.out.println(fromArray);
	int d = fromArray.findDistance(values[node1], values[node2]);
	return d;
    }
}
