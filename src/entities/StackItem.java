package entities;

import static entities.ItemType.*;

/**
 * Class for an item in the stack
 * Contains an enum for the item type
 * As well as the value with the item type
 */
public class StackItem {
    /** The entities type of the item */
    private ItemType itemtype;
    /** Stores the value as an integer */
    private int i;
    /** Stores the value as a double */
    private double d;
    /** Stores the value as a String */
    private String s;

    /**
     * Constructor for an item that stores the value as an integer
     * @param type The entities type of the item
     * @param val The value of the item (integer)
     */
    public StackItem(ItemType type, int val) {
        if (type != INT) throw new IllegalArgumentException("Wrong ItemType enum for the associated value.");
        itemtype = type;
        i = val;
        d = 0;
        s = null;
    }

    /**
     * Constructor for an item that stores the value as a double
     * @param type The entities type of the item
     * @param val The value of the item (double)
     */
    public StackItem(ItemType type, double val) {
        if (type != DOUBLE) throw new IllegalArgumentException("Wrong ItemType enum for the associated value.");
        itemtype = type;
        i = 0;
        d = val;
        s = null;
    }

    /**
     * Constructor for an item that stores the value as a String
     * @param type The entities type of the item
     * @param val The value of the item (String)
     */
    public StackItem(ItemType type, String val) {
        if (type != STRING) throw new IllegalArgumentException("Wrong ItemType enum for the associated value.");
        itemtype = type;
        i = 0;
        d = 0;
        s = val;
    }

    /**
     * Returns the integer value of this item
     * @return The integer value
     */
    public int getValueInt() {
        if (itemtype != INT) throw new RuntimeException("Attempting to retrieve integer value from an non-integer item.");
        return this.i;
    }

    /**
     * Returns the double value of this item
     * @return The double value
     */
    public double getValueDouble() {
        if (itemtype != DOUBLE) throw new RuntimeException("Attempting to retrieve double value from an non-double item.");
        return this.d;
    }

    /**
     * Returns the String value of this item
     * @return The string value
     */
    public String getValueString() {
        if (itemtype != STRING) throw new RuntimeException("Attempting to retrieve String value from an non-String item.");
        return this.s;
    }

    /**
     * Returns a string description of this item's contents
     * @return The string description
     */
    public String toString() {
        String toReturn = null;
        switch (itemtype) {
            case INT:
                toReturn = "[INT: " + this.i + "]";
                break;
            case DOUBLE:
                toReturn = "[DOUBLE: " + this.d + "]";
                break;
            case STRING:
                toReturn = "[STRING: \"" + this.s + "\"]";
                break;
        }
        return toReturn;
    }

}
