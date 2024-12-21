package fr.fidtec;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

// https://stackoverflow.com/questions/4837190/java-generics-get-class
public class ListeTableau <T>{

    private Class<T> clazz;

    public ListeTableau(Class<T> clazz) {
        this.clazz = clazz;
    }

    private ArrayList<T> arrayList =  new ArrayList<T>() ;

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
