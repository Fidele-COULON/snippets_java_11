package fr.fidtec;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StackWalkerDemo {

    public void methodOne(String branch) {
        this.methodTwo(branch);
    }

    public void methodTwo(String branch) {
        if ("A".equals(branch)) {
            this.methodThreeA();
        } else {
            this.methodThreeB();
        }
    }

    public void methodThreeA() {
        // stack walking code avec walkExample1 ou walkExample2
        // jdk.internal frames are the new ones captured by SHOW_REFLECT_FRAMES option.
        List<StackWalker.StackFrame> stackTrace = StackWalker.getInstance(StackWalker.Option.SHOW_REFLECT_FRAMES)
                .walk(this::walkExample1);

        stackTrace.forEach(System.out::println);
    }

    public void methodThreeB() {
        String methodName = StackWalker.getInstance().walk(this::walkExample3);
        System.out.println(methodName);
    }

    // In the entire stack trace, we are only interested in top four frames.
    // The remaining frames from org.junit and org.eclipse are nothing but noise frames.
    public List<StackWalker.StackFrame> walkExample1(Stream<StackWalker.StackFrame> stackFrameStream) {
        return stackFrameStream
                .collect(Collectors.toList());
    }

    // This will clear out the noise, leaving the top four lines in the stack log
    public List<StackWalker.StackFrame> walkExample2(Stream<StackWalker.StackFrame> stackFrameStream) {
        return stackFrameStream
                .filter(f -> f.getClassName().contains("fr.fidtec"))
                .collect(Collectors.toList());
    }

    public String walkExample3(Stream<StackWalker.StackFrame> stackFrameStream) {
        return stackFrameStream
                .filter(frame -> frame.getClassName().contains("fr.fidtec")
                        && frame.getClassName().endsWith("Test"))
                .findFirst()
                .map(f -> f.getClassName() + "#" + f.getMethodName() + ", Line " + f.getLineNumber())
                .orElse("Unknown caller");
    }

    // Please note that the StackWalker::getCallerClass should not be called from the method at the bottom of the stack.
    // as it will result in IllegalCallerException being thrown.
    public void findCaller() {
        Class<?> caller = StackWalker
                .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .getCallerClass();
        System.out.println(caller.getCanonicalName());
    }
}
