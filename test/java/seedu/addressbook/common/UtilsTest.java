package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {
 
    @Test
	public void isAnyNull_nullsInsideList_returnFalse() {
		// confirms nulls inside the list are not considered
        List<Object> nullList = Arrays.asList((Object) null);
        assertFalse(Utils.isAnyNull(nullList));
	}
    
    @Test
	public void isAnyNull_nonEmptyListOneNullAtLast_returnTrue() {
		// non empty list with one null as the last element
        assertTrue(Utils.isAnyNull("", new Object(), null));
        assertTrue(Utils.isAnyNull(new Object(), new Object(), null));
	}
    
    @Test
	public void isAnyNull_nonEmptyListNullsInMiddle_returnTrue() {
		// non empty list with nulls in the middle
        assertTrue(Utils.isAnyNull(new Object(), null, null, "test"));
        assertTrue(Utils.isAnyNull("", null, new Object()));
	}
    
    @Test
	public void isAnyNull_nonEmptyListOneNullAtBeginning_returnTrue() {
		// non empty list with just one null at the beginning
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, "", new Object()));
        assertTrue(Utils.isAnyNull(null, new Object(), new Object()));
	}
    
    @Test
	public void isAnyNull_nonEmptyList_returnFalse() {
		// Any non-empty list
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull("test"));
        assertFalse(Utils.isAnyNull(""));
	}
    
    @Test
	public void isAnyNull_emptyList_returnFalse() {
		// empty list
        assertFalse(Utils.isAnyNull());
	}

    @Test
	public void elementsAreUnique_someIdenticalObjects_arentUnique() {
		// some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
	}

    @Test
	public void elementsAreUnique_allObjects_areUnique() {
		// all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);
	}

    @Test
	public void elementsAreUnique_oneObject_areUnique() {
		// only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");
	}

    @Test
	public void elementsAreUnique_emptyList_areUnique() {
		// empty list
        assertAreUnique();
	}

    @Test
    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
