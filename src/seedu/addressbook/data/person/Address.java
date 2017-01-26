package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postal;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] trimmedAddressArray = trimmedAddress.split(", ");
        block = new Block(trimmedAddressArray[0]);
        street = new Street(trimmedAddressArray[1]);
        unit = new Unit(trimmedAddressArray[2]);
        postal = new PostalCode(trimmedAddressArray[0]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getValue() + ", " + street.getValue() + ", " + unit.getValue() + ", " + postal.getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    class Block {
    	
    	private final String value;
    	
    	private Block(String value) {
    		this.value = value;
    	}
    	
    	private String getValue() {
    		return value;
    	}
    }
    
    class Street {
    	
    	private final String value;
    	
    	private Street(String value) {
    		this.value = value;
    	}
    	
    	private String getValue() {
    		return value;
    	}
    }
    
    class Unit {
    	
    	private final String value;
    	
    	private Unit(String value) {
    		this.value = value;
    	}
    	
    	private String getValue() {
    		return value;
    	}
    }
    
    class PostalCode {
    	
    	private final String value;
    	
    	private PostalCode(String value) {
    		this.value = value;
    	}
    	
    	private String getValue() {
    		return value;
    	}
    }
}
