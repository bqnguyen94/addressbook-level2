package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	private Name name;
	private Name nullName;
	private Name emptyName;
	private Name upperName;
	private Name lowerName;
	private Name upperAndLowerName;
	
	@Before
	public void setup() throws IllegalValueException {
		name = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas");
		nullName = null;
		emptyName = new Name("");
		upperName = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas".toUpperCase());
		lowerName = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas".toLowerCase());
		upperAndLowerName = new Name("uvuvwEvwEvwE onyEtEnyEvwE ugwEmuhwEm ossas");
	}
	
	@Test
	public void isSimilar_nullName_returnsFalse() {
		assertFalse(name.isSimilar(nullName));
	}
	
	@Test
	public void isSimilar_emptyName_returnsFalse() {
		assertFalse(name.isSimilar(emptyName));
	}
	
	@Test
	public void isSimilar_differentCase_returnsTrue() {
		assertTrue(name.isSimilar(upperName));
		assertTrue(name.isSimilar(lowerName));
		assertTrue(name.isSimilar(upperAndLowerName));
	}
}
