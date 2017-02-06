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
	private Name subsetName;
	private Name supersetName;
	
	@Before
	public void setup() throws IllegalValueException {
		name = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas");
		nullName = null;
		emptyName = new Name("");
		upperName = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas".toUpperCase());
		lowerName = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas".toLowerCase());
		upperAndLowerName = new Name("uvuvwEvwEvwE onyEtEnyEvwE ugwEmuhwEm ossas");
		subsetName = new Name("Ossas");
		supersetName = new Name("Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Ossas");
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
	
	@Test
	public void isSimilar_subsetName_returnsFalse() {
		assertFalse(name.isSimilar(subsetName));
	}
	
	@Test
	public void isSimilar_supersetName_returnsFalse() {
		assertFalse(name.isSimilar(supersetName));
	}
}
