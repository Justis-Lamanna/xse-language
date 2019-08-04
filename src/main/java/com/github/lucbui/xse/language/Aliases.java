package com.github.lucbui.xse.language;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Aliases implements Iterable<String>{
    private String[] aliases;

    public Aliases(String[] aliases) {
        this.aliases = aliases;
    }

    public Aliases(List<String> aliases){
        this.aliases = aliases.toArray(new String[0]);
    }

    public int length(){
        return this.aliases.length;
    }

    public String at(int idx){
        return this.aliases[idx];
    }

    @Override
    public Iterator<String> iterator() {
        return Arrays.stream(aliases).iterator();
    }
}
