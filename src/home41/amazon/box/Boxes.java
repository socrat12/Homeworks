package home41.amazon.box;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import home41.amazon.box.fileWorks.FileWorks;

/**
 * Тестовое задание амазона 1.
 *
 * Есть Н ящиков и грузовик, в который влазит М ящиков. Все ящики имею
 * координаты. Закончить метод, возвращающий список М ящиков, ближайших к
 * грузовику. Грузовик имеет координаты 0-0. пример входных данных: 4,
 * [[2,3],[7,4],[3,3],[1,2]], 2
 */

public class Boxes {

    public static void main(String[] args) {
	FileWorks fw = new FileWorks("resources/box/boxes.csv");
	fw.createFile("resources/box/output.csv");
	
	while (fw.isReady()) {
	    String[] input = fw.readLine().split("[^0-9]+");
	    
	    int bosexNum = Integer.parseInt(input[0]);
	    int truckCapacity = Integer.parseInt(input[input.length - 1]);
	    
	    List<List<Integer>> crateCoords = listEjection(input);

	    List<List<Integer>> inTruck = findCrates(bosexNum, crateCoords, truckCapacity);
	    for (List<Integer> list : inTruck) {
		System.out.print(list + " ");
		fw.write(list.toString() + " ");
	    }
	    System.out.println();
	    fw.writeLine();
	}
	fw.close();
    }

    /**
     * @param input Получает массив чисел в формате стринг и, кроме первого и последнего,
     * 		 заносит их в лист листов пар интежеров
     * @return
     */
    private static List<List<Integer>> listEjection(String[] input) {
	List<List<Integer>> crateCoords = new ArrayList<List<Integer>>();
	for (int i = 1; i < input.length - 1; i++) {
	    List<Integer> coords = new ArrayList<Integer>();
	    coords.add(Integer.parseInt(input[i]));
	    coords.add(Integer.parseInt(input[++i]));
	    crateCoords.add(coords);
	}
	return crateCoords;
    }

    public static List<List<Integer>> findCrates(int cratesNum, List<List<Integer>> crateCoords, int truckCapacity) {
	crateCoords.sort(comparator());
	return crateCoords.subList(0, truckCapacity);
    }

    /**
     * @return компаратор, в зависимости от удалённости от грузовика
     */
    private static Comparator<List<Integer>> comparator() {
	Comparator<List<Integer>> c = new Comparator<List<Integer>>() {
	    @Override
	    public int compare(List<Integer> o1, List<Integer> o2) {
		int x1 = o1.get(0);
		int y1 = o1.get(1);
		int x2 = o2.get(0);
		int y2 = o2.get(1);
		return (x1 * x1 + y1 * y1) - (x2 * x2 + y2 * y2);
	    }
	};
	return c;
    }
}
