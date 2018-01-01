package containers;

import entities.StackItem;

import java.util.Stack;

/**
 * Singleton class that handles the stack of items in the calculator
 */
public class CalculatorStack {

    /** The stack containing the items */
    private static Stack<StackItem> stack = new Stack<>();

    /**
     * Private constructor to ensure one time only instatiation.
     */
    private CalculatorStack() {
//        stack = new Stack<>();
    }

    /**
     * Returns the items stack
     * @return The stack of items
     */
    public static Stack<StackItem> getStack() {
        if (stack == null) throw new RuntimeException("Stack is null for some reason.");
        return stack;
    }

}
