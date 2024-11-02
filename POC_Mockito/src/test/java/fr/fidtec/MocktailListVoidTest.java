package fr.fidtec;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

// https://www.baeldung.com/mockito-void-methods
public class MocktailListVoidTest {

    @Test
    public void whenAddCalled_thenVerified() {
        MocktailList myList = mock(MocktailList.class);
        doNothing().when(myList).add(isA(Integer.class), isA(String.class));
        myList.add(0, "");

        verify(myList, times(1)).add(0, "");
    }
}
