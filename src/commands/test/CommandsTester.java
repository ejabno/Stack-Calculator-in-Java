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

        PushCommand pushCommand = new PushCommand();
        SubtractCommand subtractCommand = new SubtractCommand();
        SwapCommand swapCommand = new SwapCommand();

        pushCommand.pushItem(INT, 4);
        pushCommand.pushItem(STRING, "Hello world!");
        System.out.println(stack.toString());

        subtractCommand.subtractItems();
        System.out.println(stack.toString());

        pushCommand.pushItem(DOUBLE, 3.2);
        swapCommand.swap();
        subtractCommand.subtractItems();
        System.out.println(stack.toString());


    }
}
