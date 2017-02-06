package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	private Name name;
	private Name nullName;
	private Name emptyName;
	
	@Before
	public void setup() throws IllegalValueException {
		name = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas");
		nullName = null;
		emptyName = new Name("");
	}
	
	@Test
	public void isSimilar_null_returnsFalse() {
		assertFalse(name.isSimilar(null));
	}
	
	@Test
	public void isSimilar_empty_returnsFalse() {
		assertFalse(name.isSimilar(emptyName));
	}
}
