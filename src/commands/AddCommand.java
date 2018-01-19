package commands;

import containers.CalculatorStack;
import entities.StackItem;

import java.util.Stack;

import static entities.ItemType.*;

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
                    case INT: //INT + INT == INT
                        int resultInt = item1.getValueInt() + item2.getValueInt();
                        resultItem = new StackItem(INT, resultInt);
                        break;
                    case DOUBLE: //INT + DBL = DBL
                        double resultDouble = (double) item1.getValueInt() + item2.getValueDouble();
                        resultItem = new StackItem(DOUBLE, resultDouble);
                        break;
                    case STRING: //INT + STR = STR
                        String resultString = item1.getValueInt() + item2.getValueString();
                        resultItem = new StackItem(STRING, resultString);
                        break;
                }
                break;
            case DOUBLE:
                switch (item2.getItemtype()) {
                    case INT: //DBL + INT = DBL
                        double resultDouble = item1.getValueDouble() + (double) item2.getValueInt();
                        resultItem = new StackItem(DOUBLE, resultDouble);
                        break;
                    case DOUBLE: //DBL + DBL = DBL
                        resultDouble = item1.getValueDouble() + item2.getValueDouble();
                        resultItem = new StackItem(DOUBLE, resultDouble);
                        break;
                    case STRING: //DBL + STR = STR
                        String resultString = item1.getValueDouble() + item2.getValueString();
                        resultItem = new StackItem(STRING, resultString);
                        break;
                }
                break;
            case STRING:
                switch (item2.getItemtype()) {
                    case INT: //STR + INT = STR
                        String resultString = item1.getValueString() + item2.getValueInt();
                        resultItem = new StackItem(STRING, resultString);
                        break;
                    case DOUBLE: //STR + DBL = STR
                        resultString = item1.getValueString() + item2.getValueDouble();
                        resultItem = new StackItem(STRING, resultString);
                        break;
                    case STRING: //STR + STR = STR
                        resultString = item1.getValueString() + item2.getValueString();
                        resultItem = new StackItem(STRING, resultString);
                        break;
                }
                break;
        }
        stack.push(resultItem);
        this.successful = true;
    }
}
