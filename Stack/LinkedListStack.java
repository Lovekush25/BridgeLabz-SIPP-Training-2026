class CallStack {

    private static class Frame {
        String functionName;
        Frame next;

        Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }

    private Frame top;

    void push(String functionName) {
        top = new Frame(functionName, top);
    }

    String pop() {
        if (isEmpty()) {
            throw new RuntimeException("No active call");
        }

        String name = top.functionName;
        top = top.next;
        return name;
    }

    String peek() {
        if (isEmpty()) {
            throw new RuntimeException("No active call");
        }

        return top.functionName;
    }

    boolean isEmpty() {
        return top == null;
    }
}