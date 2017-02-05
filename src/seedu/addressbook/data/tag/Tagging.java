package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.*;

import java.util.ArrayList;

public class Tagging {

	/**
     * Type of tagging
     */
    public static enum TaggingType {
        ADD, 
        DELETE
    }

    private final ReadOnlyPerson person;
    private final Tag tag;
    private final TaggingType type;

    public Tagging(ReadOnlyPerson person, Tag tag, TaggingType type) {
        this.person = person;
        this.tag = tag;
        this.type = type;
    }
    
    @Override
    public String toString() {
    	String taggingSymbol = "+";
    	if (this.type == TaggingType.DELETE) {
    		taggingSymbol = "-";
    	}
        return taggingSymbol + " " + person.getName() + tag.toString();
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tagging // instanceof handles nulls
                && toString().equals(((Tagging) other).toString())); // state check
    }
}