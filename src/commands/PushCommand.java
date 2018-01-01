package commands;

import containers.CalculatorStack;
import entities.ItemType;
import entities.StackItem;

import java.util.Stack;

import static entities.ItemType.*;

/**
 * Class that handles pushing of an item in the stack
 */
public class PushCommand extends CommandStatus {
    /**
     * Implementation of the push command for integers
     * @param type The item type of the item to push
     * @param val The integer value
     */
    public void pushItem(ItemType type, int val) {
        if (type != INT) {
            this.errorMessage = "Incompatible item type passed (not an integer)";
            this.successful = false;
            return;
        }

        Stack<StackItem> stack = null;

        try {
            stack = CalculatorStack.getStack();
        }
        catch (Exception e) {
            this.errorMessage = "Error in retrieving the stack from the stack access singleton.";
            this.successful = false;
            return;
        }

        StackItem newItem = null;
        try {
            newItem = new StackItem(type, val);
        }
        catch (Exception e) {
            this.errorMessage = "Error creating item (possible incompatible types passed).";
            this.successful = false;
            return;
        }

        stack.add(newItem);
        this.successful = true;
    }

    /**
     * Implementation of the push command for doubles
     * @param type The item type of the item to push
     * @param val The double value
     */
    public void pushItem(ItemType type, double val) {
        if (type != DOUBLE) {
            this.errorMessage = "Incompatible item type passed (not a double)";
            this.successful = false;
            return;
        }

        Stack<StackItem> stack = null;

        try {
            stack = CalculatorStack.getStack();
        }
        catch (Exception e) {
            this.errorMessage = "Error in retrieving the stack from the stack access singleton.";
            this.successful = false;
            return;
        }

        StackItem newItem = null;
        try {
            newItem = new StackItem(type, val);
        }
        catch (Exception e) {
            this.errorMessage = "Error creating item (possible incompatible types passed).";
            this.successful = false;
            return;
        }

        stack.add(newItem);
        this.successful = true;
    }

    /**
     * implementation of the push command for Strings
     * @param type The item type of the item to push
     * @param val The String value
     */
    public void pushItem(ItemType type, String val) {
        if (type != STRING) {
            this.errorMessage = "Incompatible item type passed (not a String)";
            this.successful = false;
            return;
        }

        if (val == null) {
            this.errorMessage = "Error attempting to push an item containing a null string.";
            this.successful = false;
            return;
        }

        Stack<StackItem> stack = null;

        try {
            stack = CalculatorStack.getStack();
        }
        catch (Exception e) {
            this.errorMessage = "Error in retrieving the stack from the stack access singleton.";
            this.successful = false;
            return;
        }

        StackItem newItem = null;
        try {
            newItem = new StackItem(type, val);
        }
        catch (Exception e) {
            this.errorMessage = "Error creating item (possible incompatible types passed).";
            this.successful = false;
            return;
        }

        stack.add(newItem);
        this.successful = true;
    }

}
