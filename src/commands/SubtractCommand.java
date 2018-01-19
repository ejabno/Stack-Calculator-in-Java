package commands;

import containers.CalculatorStack;
import entities.StackItem;

import java.util.Stack;

import static entities.ItemType.*;

/**
 * Class that handles the subtraction operation of the two topmost items off the stack
 */
public class SubtractCommand extends CommandStatus {
    /**
     * The command implementation for subtraction
     */
    public void subtractItems() {
        Stack<StackItem> stack;
        try {
            stack = CalculatorStack.getStack();
        }
        catch (Exception e) {
            this.errorMessage = "Attempting to subtract items from a null stack.";
            this.successful = false;
            return;
        }

        if (stack.size() < 2) {
            this.errorMessage = "Not enough items in the stack to subtract together.";
            this.successful = false;
            return;
        }

        StackItem item1, item2;
        try {
            item1 = stack.pop();
            item2 = stack.pop();
        }
        catch (Exception e) {
            this.errorMessage = "Error popping from a stack without enough items (This should not happen!)";
            this.successful = false;
            return;
        }

        StackItem resultItem = null;
        switch (item1.getItemtype()) {
            case INT:
                switch (item2.getItemtype()) {
                    case INT: //INT - INT == INT
                        int resultInt = item1.getValueInt() - item2.getValueInt();
                        resultItem = new StackItem(INT, resultInt);
                        break;
                    case DOUBLE: //INT - DBL = DBL
                        double resultDouble = (double) item1.getValueInt() - item2.getValueDouble();
                        resultItem = new StackItem(DOUBLE, resultDouble);
                        break;
                    case STRING: //INT - STR = N/a
                        stack.push(item2);
                        stack.push(item1);
                        this.errorMessage = "Integer - String operation is not supported.";
                        this.successful = false;
                        return;
                }
                break;
            case DOUBLE:
                switch (item2.getItemtype()) {
                    case INT: //DBL - INT = DBL
                        double resultDouble = item1.getValueDouble() - (double) item2.getValueInt();
                        resultItem = new StackItem(DOUBLE, resultDouble);
                        break;
                    case DOUBLE: //DBL - DBL = DBL
                        resultDouble = item1.getValueDouble() - item2.getValueDouble();
                        resultItem = new StackItem(DOUBLE, resultDouble);
                        break;
                    case STRING: //DBL - STR = N/A
                        stack.push(item2);
                        stack.push(item1);
                        this.errorMessage = "Double - String operation is not supported.";
                        this.successful = false;
                        return;
                }
                break;
            case STRING:
                switch (item2.getItemtype()) {
                    case INT: //STR - INT = STR
                        if (item2.getValueInt() < 0) {
                            stack.push(item2);
                            stack.push(item1);
                            this.errorMessage = "Can's subtract strings by negative amounts.";
                            this.successful = false;
                            return;
                        }
                        int resultLength = item1.getValueString().length() - item2.getValueInt();
                        if (resultLength > 0) {
                            String resultString = (new StringBuilder(item1.getValueString())).substring(0,resultLength);
                            resultItem = new StackItem(STRING, resultString);
                        }
                        else {
                            resultItem = new StackItem(STRING, "");
                        }
                        break;
                    case DOUBLE: //STR + DBL = STR
                        if (item2.getValueDouble() < 0.0) {
                            stack.push(item2);
                            stack.push(item1);
                            this.errorMessage = "Can's subtract strings by negative amounts.";
                            this.successful = false;
                            return;
                        }
                        resultLength = item1.getValueString().length() - (int) item2.getValueDouble();
                        if (resultLength > 0) {
                            String resultString = (new StringBuilder(item1.getValueString())).substring(0,resultLength);
                            resultItem = new StackItem(STRING, resultString);
                        }
                        else {
                            resultItem = new StackItem(STRING, "");
                        }
                        break;
                    case STRING: //STR + STR = N/A
                        stack.push(item2);
                        stack.push(item1);
                        this.errorMessage = "String - String operation is not supported.";
                        this.successful = false;
                        return;
                }
                break;
        }
        stack.push(resultItem);
        this.successful = true;
    }
}
