package com.github.lucbui.xse.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ReadOnlyIterable<T> implements Iterable<T> {

    private List<T> list;

    public ReadOnlyIterable(T[] array){
        this.list = Arrays.asList(array);
    }

    public ReadOnlyIterable(List<T> list){
        this.list = new ArrayList<>(list);
    }

    public T at(int idx){
        return list.get(idx);
    }

    public int length(){
        return list.size();
    }

    public Stream<T> stream(){
        return list.stream();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
