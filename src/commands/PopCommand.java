package commands;

import containers.CalculatorStack;
import entities.StackItem;

import java.util.Stack;

/**
 * Class that handles popping an item off the stack
 */
public class PopCommand extends CommandStatus {
    /**
     * Implementation of the pop command
     */
    public void popItem() {
        Stack<StackItem> stack = null;
        try {
            stack = CalculatorStack.getStack();
        }
        catch (Exception e) {
            this.errorMessage = "Attempting to pop from a null stack.";
            this.successful = false;
            return;
        }

        try {
            stack.pop();
        }
        catch (Exception e) {
            this.errorMessage = "Attempting to pop from an empty stack.";
            this.successful = false;
            return;
        }
        this.successful = true;
    }
}
