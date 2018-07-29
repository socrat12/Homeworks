package com.itStep.home32.Set;

public interface ShagoSet<N> {
    
    void add(N element);

    void remove(N element);

    boolean contains(N element);

    int size();
}
