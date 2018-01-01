package commands;

import containers.CalculatorStack;
import entities.StackItem;

import java.util.Stack;

/**
 * Class that handles the addition operation of the two topmost items off the stack
 */
public class AddCommand extends CommandStatus {
    /**
     * The command implementation for addition
     */
    public void addItems() {
        Stack<StackItem> stack;
        try {
            stack = CalculatorStack.getStack();
        }
        catch (Exception e) {
            this.errorMessage = "Attempting to add items from a null stack.";
            this.successful = false;
            return;
        }

        if (stack.size() < 2) {
            this.errorMessage = "Not enough items in the stack to add together.";
            this.successful = false;
            return;
        }
    }
}
