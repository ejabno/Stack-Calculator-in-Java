package commands;

/**
 * Java class that is the base (superclass) of all the command implementations for the calculator
 * Contains an execution status and error message, if applicable
 */
public class CommandStatus {
    /** The status of the command execution, initially set to false*/
    protected boolean successful = false;
    /** The error message of the command if it failed, initially is a null string */
    protected String errorMessage = null;

    /**
     * Determines if the command ran successfully or not
     * @return True if successful, false otherwise
     */
    public boolean wasSuccessful() {
        return successful;
    }

    /**
     * Returns the error message if the command failed to run successfully.
     * @return The error message
     */
    public String getErrorMessage() {
        if (wasSuccessful()) throw new RuntimeException("" +
                "Attempting to get an error message from a successful command execution.");
        return errorMessage;
    }

}
