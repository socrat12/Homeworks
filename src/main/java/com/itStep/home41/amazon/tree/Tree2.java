package com.itStep.home41.amazon.tree;

public class Tree2 extends Tree {
    @Override
    public int findDistance(int value1, int value2) {
	Node current = root;
	// найти узел, начиная с которого поиск значений уходит в разные строны
	while ((value1 > current.value && value2 > current.value) || (value1 < current.value && value2 < current.value)) {
	    if (value1 < current.value) {
		current = current.left;
	    } else if (value1 > current.value) {
		current = current.right;
	    }
	}
	// вернуть сумму рёбер от этого узла до двух искомых
	return ribAmount(current,value1) + ribAmount(current,value2);
    }
    
    private int ribAmount(Node current, int value) {
	int dist = 0;
	while (true) {
	    if (value < current.value) {
		current = current.left;
		dist++;
	    } else if (value > current.value) {
		current = current.right;
		dist++;
	    } else return dist;
	}
    }
}
