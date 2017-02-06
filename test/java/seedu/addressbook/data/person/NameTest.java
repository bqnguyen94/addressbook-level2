package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	private Name name;
	
	@Before
	public void setup() throws IllegalValueException {
		name = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas");
	}
	
	@Test
	public void isSimilar_null_returnsFalse() {
		assertFalse(name.isSimilar(null));
	}
}
