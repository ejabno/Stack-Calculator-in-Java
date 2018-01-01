package commands;

import containers.CalculatorStack;
import entities.StackItem;

import java.util.Stack;

import static entities.ItemType.*;

/**
 * Class that handles the reversal of contents of an item on the top of the stack
 * Only if it is a String-type item
 */
public class ReverseCommand extends CommandStatus{
    /**
     * The command implementation for reversing Strings
     */
    public void reverseString() {
        Stack<StackItem> stack;
        try {
            stack = CalculatorStack.getStack();
        }
        catch (Exception e) {
            this.errorMessage = "Attempting to reverse an item's contents from a null stack.";
            this.successful = false;
            return;
        }

        StackItem toReverse;
        try {
            toReverse = stack.pop();
        }
        catch (Exception e) {
            this.errorMessage = "Popping from a stack that doesn't have enough items (This should not happen!)";
            this.successful = false;
            return;
        }

        String reversedString;
        try {
            reversedString = (new StringBuilder(toReverse.getValueString())).reverse().toString();
        }
        catch (Exception e) {
            stack.push(toReverse);
            this.errorMessage = "Error reversing a non-String type item.";
            this.successful = false;
            return;
        }

        try {
            toReverse = new StackItem(STRING, reversedString);
        }
        catch (Exception e) {
            this.errorMessage = "StackItem initializer failed to initialize String type properly for some reason.";
            this.successful = false;
            return;
        }

        stack.push(toReverse);
        this.successful = true;
    }
}
