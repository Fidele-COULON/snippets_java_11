package fr.fidtec;

import org.junit.jupiter.api.Test;

// https://www.baeldung.com/java-9-stackwalking-api
public class StackWalkerDemoTest {
    @Test
    void giveStalkWalker_whenWalkingTheStack_thenShowStackFramesA() {
        new StackWalkerDemo().methodOne("A");
    }

    @Test
    void giveStalkWalker_whenWalkingTheStack_thenShowStackFramesB() {
        new StackWalkerDemo().methodOne("B");
    }

    @Test
    void giveStalkWalker_whenInvokingFindCaller_thenFindCallingClass() {
        new StackWalkerDemo().findCaller();
    }
}
