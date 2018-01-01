package commands;

import containers.CalculatorStack;
import entities.StackItem;

import java.util.Stack;

/**
 * Class that handles the swapping of items off the stack
 */
public class SwapCommand extends CommandStatus {
    /**
     * Implementation of the swap command
     */
    public void swap() {
        Stack<StackItem> stack = null;

        try {
            stack = CalculatorStack.getStack();
        }
        catch(Exception e) {
            this.errorMessage = "Attempting to swap items from a null stack.";
            this.successful = false;
            return;
        }

        if (stack.size() < 2) {
            this.errorMessage = "Not enough items in the stack to swap.";
            this.successful = false;
            return;
        }

        StackItem item1 = null;
        StackItem item2 = null;

        try {
            item1 = stack.pop();
            item2 = stack.pop();
        }
        catch (Exception e) {
            this.errorMessage = "Popping from a stack that doesn't have enough items (This should not happen!)";
            this.successful = false;
            return;
        }

        stack.push(item1);
        stack.push(item2);
        this.successful = true;
    }
}
