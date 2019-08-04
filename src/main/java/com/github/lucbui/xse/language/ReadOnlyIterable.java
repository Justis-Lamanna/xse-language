package com.github.lucbui.xse.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * A read-only array
 * @param <T>
 */
public class ReadOnlyIterable<T> implements Iterable<T> {

    private List<T> list;

    /**
     * Create a read-only array from an array.
     * @param array The array
     */
    public ReadOnlyIterable(T[] array){
        this(Arrays.asList(array));
    }

    /**
     * Create a read-only array from a list
     * @param list The list
     */
    public ReadOnlyIterable(List<T> list){
        this.list = new ArrayList<>(list);
    }

    /**
     * Get the value at the index
     * @param idx The index
     * @return The value
     */
    public T at(int idx){
        return list.get(idx);
    }

    /**
     * Get the size of the array
     * @return The size
     */
    public int length(){
        return list.size();
    }

    /**
     * Get a stream of this array
     * @return A stream of this array's elements
     */
    public Stream<T> stream(){
        return list.stream();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
