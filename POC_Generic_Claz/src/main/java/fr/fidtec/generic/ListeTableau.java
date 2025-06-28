package fr.fidtec.generic;

import java.util.ArrayList;

public class ListeTableau <T> {

    private final ArrayList<T> arrayList =  new ArrayList<>() ;

    private final Class<T> clazz;

    public ListeTableau(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T get(int index) {
        return arrayList.get(index);
    }

    public void add(T t) {
        arrayList.add(t);
    }

    public int count() {
        return arrayList.size();
    }

    public String getClazz() {
        return clazz.toString();
    }
}
