import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testContactPass() {
        Contact testContact = new Contact("1234", "Joe", "Limbert", "9784152145", "11 main st.");
        assertTrue(testContact.getId().length() <= 10);
        assertTrue(testContact.getFirstName().length() <= 10);
        assertTrue(testContact.getLastName().length() <= 10);
        assertEquals(10, testContact.getPhone().length());
        assertTrue(testContact.getAddress().length() <= 30);
        assertEquals("1234", testContact.getId());
        assertEquals("Joe", testContact.getFirstName());
        assertEquals("Limbert", testContact.getLastName());
        assertEquals("9784152145", testContact.getPhone());
        assertEquals("11 main st.", testContact.getAddress());
    }

    @Test
    public void testContactFailIdNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Joe", "Limbert", "9784152145", "11 main st."));
        assertEquals("ID cannot be null", exception.getMessage());
    }

    @Test
    public void testContactFailIdLength() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1534654654651352132465", "Joe", "Limbert", "9784152145", "11 main st."));
        assertEquals("ID must be less than 10 characters", exception.getMessage());
    }

    @Test
    public void testContactFailFirstNameNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("15346546", null, "Limbert", "9784152145", "11 main st."));
        assertEquals("First name cannot be null", exception.getMessage());
    }

    @Test
    public void testContactFailFirstNameLength() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("35245", "dfsgdfgfdsgdsfgfdsg", "Limbert", "9784152145", "11 main st."));
        assertEquals("First name must be less than 10 characters", exception.getMessage());
    }

    @Test
    public void testContactFailLastNameNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("45641", "Joe", null, "9784152145", "11 main st."));
        assertEquals("Last name cannot be null", exception.getMessage());
    }

    @Test
    public void testContactFailLastNameLength() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("32424", "Joe", "sdfsdfsafggdfgsgdsf", "978415214587", "11 main st."));
        assertEquals("Last name must be less than 10 characters", exception.getMessage());
    }

    @Test
    public void testContactFailPhoneNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("46511", "Joe", "Limbert", null, "11 main st."));
        assertEquals("Phone number cannot be null", exception.getMessage());
    }

    @Test
    public void testContactFailPhoneLength() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("32424", "Joe", "Limbert", "978415214587", "11 main st."));
        assertEquals("Phone number must be exactly 10 characters", exception.getMessage());
    }

    @Test
    public void testContactFailAddressNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("4651", "Joe", "Limbert", "9784152145", null));
        assertEquals("Address cannot be null", exception.getMessage());
    }

    @Test
    public void testContactFailAddressLength() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Contact("234234", "Joe", "Limbert", "9784152145", "11 main st.fasdfsdfsd da fdsaf dskahflkjsdah flksdahflksd"));
        assertEquals("Address must be less than 30 characters", exception.getMessage());
    }
}
