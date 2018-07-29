package com.itStep.home45.labyrinth;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class MyLabyrinth {

    private static boolean[][] cell = new boolean[7][7];

    public static void main(String[] args) throws InterruptedException {
	borderCreator();
	cell[1][3] = cell[2][3] = cell[3][2] = cell[3][3] = cell[4][4] = cell[5][2] = true;
	cell[4][0] = false;
	printLab();

	int[] current = { 2, 4 };
	LinkedList<int[]> path = new LinkedList<int[]>();
	Set<String> used = new TreeSet<String>();
	used.add("13");

	while (true) {
	    try {
		int[] ij = findAround(current, used);
		Thread.sleep(100);
		path.add(current);
		current = ij;
		System.out.println(current[0] + "" + current[1]);
	    } catch (FileNotFoundException e) {
		try {
		    current = path.get(path.size() - 1);
		    System.out.println(current[0] + "" + current[1]);
		    path.removeLast();
		} catch (IndexOutOfBoundsException e2) {
		    System.out.println("No exit");
		    System.exit(0);
		}
	    }
	    if (current[0] == 4 && current[1] == 0) {
		System.out.println("Done");
		break;
	    }
	}
    }

    private static int[] findAround(int[] current, Set<String> used) throws FileNotFoundException {
	int[] ij = new int[2];
	ij[0] = current[0];
	ij[1] = current[1];
	int[] k = { 0, 0, -1, 1 };
	int[] l = { -1, 1, 0, 0 };

	for (int i = 0; i < l.length; i++) {
		String toAdd = (ij[0] + k[i]) + "" + (ij[1] + l[i]);
		if (!cell[ij[0] + k[i]][ij[1] + l[i]] && used.add(toAdd)) {
		    ij[0] -= 1;
		    return ij;
		}
	    }
	throw new FileNotFoundException();
    }

    private static void printLab() {
	for (int i = 0; i < cell.length; i++) {
	    for (int j = 0; j < cell[i].length; j++) {
		System.out.print((cell[i][j] ? "X" : " "));
	    }
	    System.out.println();
	}
    }

    private static void borderCreator() {
	for (int i = 0; i < cell.length; i += cell.length - 1) {
	    for (int j = 0; j < cell[i].length; j++) {
		cell[i][j] = true;
		cell[j][i] = true;
	    }
	}
    }
}
