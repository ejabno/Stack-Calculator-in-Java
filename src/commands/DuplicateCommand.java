package commands;

import containers.CalculatorStack;
import entities.StackItem;

import java.util.Stack;

/**
 * Class that handles the duplication of the topmost item in the stack
 */
public class DuplicateCommand extends CommandStatus {
    /**
     * Implementation of the duplicate command
     */
    public void duplicate() {
        Stack<StackItem> stack = null;

        try {
            stack = CalculatorStack.getStack();
        }
        catch(Exception e) {
            this.errorMessage = "Attempting to duplicate from a null stack.";
            this.successful = false;
            return;
        }

        if (stack.size() < 1) {
            this.errorMessage = "Not enough items in the stack to duplicate.";
            this.successful = false;
            return;
        }

        StackItem copy;

        try {
            copy = stack.peek();
        }
        catch (Exception e) {
            this.errorMessage = "Popping from a stack that doesn't have enough items (This should not happen!)";
            this.successful = false;
            return;
        }

        stack.push(copy);
        this.successful = true;
    }
}
