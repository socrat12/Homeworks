package com.itStep.home41.amazon.tree;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Tree {

    /**
     *  корень дерева
     */
    protected Node root;

    /**
     * @param value добавление элемента в дерево
     */
    public void add(int value) {
	if (root == null) {
	    root = new Node(value);
	    return;
	}
	
	Node current = root;
	while (true) {
	    if (value < current.value) {
		if (current.left != null) {
		    current = current.left;
		} else {
		    current.left = new Node(value);
		    current.left.parrent = current;
		    return;
		}
	    } else if (value > current.value) {
		if (current.right != null) {
		    current = current.right;
		} else {
		    current.right = new Node(value);
		    current.right.parrent = current;
		    return;
		}
	    } else return;
	}
    }
    
    /**
     * @param value1
     * @param value2
     * @return возвращает количество ребёр между узлами значений <b>value1</b> и <b>value2</b>
     */
    public int findDistance(int value1, int value2) {
	int distance = 0;
	int valueMax = Math.max(value1, value2);
	int valueMin = Math.min(value1, value2);
	
	Node current = currentPos(valueMax);
	// последний узел, из которого вернулись 
	Node prev = current;
	// очередь-map для избегания ситуаций, когда левый "рукав" окажется тупиком
	QueueMap<Node, Integer> nodes = new QueueMap<Node, Integer>(); 
	
	while (true) {
	    if (nodes.size() != 0) {
		Entry<Node, Integer> nodeQueueLast = nodes.getLast();
		// если зашло в тупик и вернулось на узел, в котором было уже 
		if (current.equals(nodeQueueLast.getKey())) {
		    //вернуть значение дистанции, которые было на этом узле
		    distance = nodeQueueLast.getValue();
		    //перейти на уровень вверх
		    current = current.parrent;
		    //удалить из очереди этот узел
		    nodes.remove(nodeQueueLast.getKey());
		    distance++;
		    continue;
		}
	    }
	    if (valueMin < current.value) {
		// если левый узел не пустой и в него ещё не заходили
		if (current.left != null && current.left != prev) {
		    // поместить последний узел в список узлов
		    nodes.put(current, distance);
		    //перейти на левый узел
		    current = current.left;
		} else {
		    prev = current;
		    current = current.parrent;
		}
		distance++;
	    } else if (valueMin > current.value) {
		if (current.right != null) {
		    current = current.right;
		    distance++;
		}
	    } else
		return distance;
	}
    }
    
    /**
     * @param value
     * @return узел в котором находится значение из параметра <b>value</b>
     */
    private Node currentPos(int value) {
	Node current = root;
	while (current.left != null || current.right != null) {
	    if (value < current.value) {
		if (current.left != null) {
		    current = current.left;
		}
	    } else if (value > current.value) {
		if (current.right != null) {
		    current = current.right;
		}
	    } else return current;
	}
	return current;
    }

    @Override
    public String toString() {
	return toString(root);
    }

    private String toString(Node current) {
	if (current == null) {
	    return "";
	}

	return toString(current.left) + " " + current.value + toString(current.right);
    }

    /**
     *  Класс, описывающий узлы дерева
     *
     */
    protected class Node {
	public int value;
	public Node parrent;
	public Node left;
	public Node right;

	public Node(int value) {
	    this.value = value;
	}
    }
    
    /**
     * Очередь из map, реализован один дополнительный метод - получение последнего элемента
     *
     * @param <N> 
     * @param <I>
     */
    @SuppressWarnings("serial")
    private class QueueMap<N, I> extends LinkedHashMap<N, I> {
	public Entry<N, I> getLast() {
	    Iterator<Entry<N, I>> it = this.entrySet().iterator();
	    for (int i = 0; i < this.size() - 1; i++) {
		it.next();
	    }
	    
	    return it.next();
	}
    }
}
