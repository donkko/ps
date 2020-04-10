package p155;

import java.util.LinkedList;

public class MinStack {
    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.addLast(x);
        if (minStack.isEmpty() || x < minStack.getLast()) {
            minStack.addLast(x);
        } else {
            minStack.addLast(minStack.getLast());
        }
    }

    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
