import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    ContactService contactService = new ContactService();

    @BeforeEach
    void addContacts() {
        contactService.addContact("Joe", "Limbert", "9781542154", "11 main st.");
        contactService.addContact("Joe", "Limbert", "9781542154", "11 main st.");
        contactService.addContact("Joe", "Limbert", "9781542154", "11 main st.");
        contactService.addContact("Joe", "Limbert", "9781542154", "11 main st.");
    }
    @Test
    public void testContactUniqueID() {
        assertNotEquals(contactService.contacts.get(0).getId(), contactService.contacts.get(1).getId());
        assertNotEquals(contactService.contacts.get(0).getId(), contactService.contacts.get(2).getId());
        assertNotEquals(contactService.contacts.get(0).getId(), contactService.contacts.get(3).getId());
        assertNotEquals(contactService.contacts.get(1).getId(), contactService.contacts.get(2).getId());
        assertNotEquals(contactService.contacts.get(1).getId(), contactService.contacts.get(3).getId());
        assertNotEquals(contactService.contacts.get(2).getId(), contactService.contacts.get(3).getId());
    }

    @Test
    public void testDeleteContact() {
        int sizeBeforeDelete = contactService.contacts.size();
        contactService.deleteContact(contactService.contacts.getFirst().getId());
        assertNotEquals(contactService.contacts.size(), sizeBeforeDelete);
    }

    @Test
    public void testDeleteContactNotFound() {
        int sizeBeforeDelete = contactService.contacts.size();
        contactService.deleteContact("123456461");
        assertEquals(contactService.contacts.size(), sizeBeforeDelete);
    }

    @Test
    public void testUpdateContact() {
        contactService.updateContact(contactService.contacts.getFirst().getId(), "Bill", "Simmons", "9781549324", "26 front st.");
        Contact updatedContact = contactService.contacts.getFirst();
        assertEquals(contactService.contacts.getFirst().getId(), updatedContact.getId());
        assertEquals("Bill", updatedContact.getFirstName());
        assertEquals("Simmons", updatedContact.getLastName());
        assertEquals("9781549324", updatedContact.getPhone());
        assertEquals("26 front st.", updatedContact.getAddress());
    }
}
