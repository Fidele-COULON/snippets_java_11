package fr.fidtec.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

// https://www.baeldung.com/mockito-void-methods
class MocktailListVoidTest {

    @Test
    void whenAddCalled_thenVerified() {
        // Given
        MocktailList mocktailList = mock(MocktailList.class);
        doNothing().when(mocktailList).add(isA(Integer.class), isA(String.class));

        // When
        mocktailList.add(0, "");

        // Then
        verify(mocktailList, times(1)).add(0, "");
    }

    // doNothing() is Mockito’s default behavior for void methods.
    @Test
    void whenAddCalled_thenVerified_light() {
        // Given
        MocktailList mocktailList = mock(MocktailList.class);

        // When
        mocktailList.add(0, "");

        // Then
        verify(mocktailList, times(1)).add(0, "");
    }

    @Test
    void givenNull_whenAddCalled_thenThrowsException() {
        // Given
        MocktailList mocktailList = mock(MocktailList.class);

        // Then
        assertThrows(Exception.class, () -> {
            doThrow().when(mocktailList).add(isA(Integer.class), isNull());
        });

        // When
        mocktailList.add(0, null);

    }

    @Test
    void givenArgumentCaptor_whenAddCalled_thenValueCaptured() {
        // Given
        MocktailList mocktailList = mock(MocktailList.class);

        ArgumentCaptor<String> valueCapture = ArgumentCaptor.forClass(String.class);
        doNothing().when(mocktailList).add(any(Integer.class), valueCapture.capture());

        // When
        mocktailList.add(0, "captured");

        // Then
        assertEquals("captured", valueCapture.getValue());
    }

    @Test
    void givenDoAnswer_whenAddCalled_thenAnswered() {
        // Given
        MocktailList mocktailList = mock(MocktailList.class);

        // Then
        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(3, arg0);
            assertEquals("answer me", arg1);

            return null;

        }).when(mocktailList).add(any(Integer.class), any(String.class));

        // When
        mocktailList.add(3, "answer me");
    }

}
