package fr.fidtec;

// https://www.baeldung.com/mockito-void-methods
public class MocktailListVoidTest {

    @Test
    public void whenAddCalled_thenVerified() {
        MyList myList = mock(MyList.class);
        doNothing().when(myList).add(isA(Integer.class), isA(String.class));
        myList.add(0, "");

        verify(myList, times(1)).add(0, "");
    }
}
