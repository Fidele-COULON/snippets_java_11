package fr.fidtec.mocks;

import java.util.AbstractList;

public class MocktailList extends AbstractList<String> {

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public void add(int index, String element) {
        // some code
    }

    @Override
    public int size() {
        return 0;
    }
}
