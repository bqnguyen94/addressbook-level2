package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import seedu.addressbook.ui.TextUi;

import java.io.PrintStream;
import java.util.List;

public class Formatter {
	
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    private final PrintStream out;
    
    public Formatter(PrintStream out) {
    	this.out = out;
    }
    
    /**
     * Return a message formatted with LS and LINE_PREFIX
     * @param message is the input message
     * @return the formatted message
     */
    public String getMessage(String message) {
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
    
    /** Shows message(s) to the user */
    public void showToUser(String... message) {
        for (String m : message) {
        	out.println(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
    }
    
    /**
     * Return a welcome message based on version & storageFilePath
     * @param version
     * @param storageFilePath
     * @return the formatted welcome message
     */
    public void showWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        showToUser(
        		 DIVIDER,
        		 DIVIDER,
        		 MESSAGE_WELCOME,
        		 version,
        		 MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
        		 storageFileInfo,
        		 DIVIDER);
    }
    
    /**
     * Return a formatted goodbye message
     * @return the goodbye message
     */
    public String showGoodbyeMessage() {
        return MESSAGE_GOODBYE + DIVIDER + DIVIDER;
    }
    
    /**
     * Return a formatted init failure message
     * @return the init failure message
     */
    public String showInitFailedMessage() {
        return MESSAGE_INIT_FAILED + DIVIDER + DIVIDER;
    }
    
    /**
     * Format the result to user
     * @param resultMessage
     * @return formatted result message
     */
    public void showResultMessage(String resultMessage) {
        showToUser(resultMessage, DIVIDER);
    }
    
    /** Shows a list of strings to the user, formatted as an indexed list. */
    public void showToUserAsIndexedList(List<String> list) {
        showToUser(getIndexedListForViewing(list));
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    private String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + TextUi.DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}