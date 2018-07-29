package com.itStep.home32.Set;

import java.util.Comparator;

public class TreeShagoSet<N> implements ShagoSet<N> {
    
    private Comparator<N> comparator;
    public Node<N> root = null;
    private int size = 0;
    
    public TreeShagoSet(Comparator<N> comparator) {
	this.comparator = comparator;
    }

    public int size() {
	return size;
    }

    @Override
    public void add (N element) {
	Node<N> newNode = new Node<N>(element);
	if (root == null) {
	    root = newNode;
	    size++;
	    return;
	}

	Node<N> current = root;
	while (true) {
	    if (comparator.compare(element, current.value) == 0) {
		return;
	    }

	    if (comparator.compare(element, current.value) > 0) {
		if (current.right == null) {
		    current.right = newNode;
		    size++;
		    break;
		}
		current = current.right;
	    } else {
		if (current.left == null) {
		    current.left = newNode;
		    size++;
		    break;
		}
		current = current.left;
	    }
	}

    }

    @Override
    public void remove(N element) {
	Node<N> current = root;
	
	if (comparator.compare(element, root.value) == 0) {
	    root = null;
	}
	
	while (true) {
	    if (comparator.compare(element, current.value) > 0) {
		if (current.right == null) {
		    return;
		}
		if (comparator.compare(element, current.right.value) == 0) {
		    current.right = null;
		    return;
		}
		current = current.right;
	    } else {
		if (current.left == null) {
		    return;
		}
		if (comparator.compare(element, current.left.value) == 0) {
		    current.left = null;
		    return;
		}
		current = current.left;
	    }
	}
    }

    @Override
    public boolean contains(N element) {
	Node<N> current = root;
	while (true) {
	    if (comparator.compare(element, current.value) == 0) {
		return true;
	    }

	    if (comparator.compare(element, current.value) > 0) {
		if (current.right == null) {
		    return false;
		}
		current = current.right;
	    } else {
		if (current.left == null) {
		    return false;
		}
		current = current.left;
	    }
	}
    }

    @Override
    public String toString() {
	return toString(root);
    }

    private String toString(Node<N> current) {
	if (current == null) {
	    return "";
	}
	
	return toString(current.left) + " " + current.value + toString(current.right);
    }

    private static class Node<N> {
	public N value;
	public Node<N> left;
	public Node<N> right;

	public Node(N value) {
	    this.value = value;
	}
    }
}
