package commands.test;

import commands.*;
import containers.CalculatorStack;
import entities.StackItem;

import java.util.Stack;

import static entities.ItemType.*;

/**
 * Tester command that tests the PushCommand class
 */
public abstract class CommandsTester {
    public static void runTest() {
        Stack<StackItem> stack = null;
        try {
            stack = CalculatorStack.getStack();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(stack.toString());

        PushCommand pushCommand = new PushCommand();
        pushCommand.pushItem(STRING, "Hello world!");

        System.out.println(stack.toString());

        ReverseCommand reverseCommand = new ReverseCommand();
        reverseCommand.reverseString();

        System.out.println(stack.toString());

        pushCommand.pushItem(DOUBLE, 64.3);
        System.out.println(stack.toString());

        reverseCommand.reverseString();
        System.out.println(stack.toString());
        System.out.println(reverseCommand.getErrorMessage());

    }
}
