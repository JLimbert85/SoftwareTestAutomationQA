import java.util.ArrayList;

public class ContactService {
    Integer id = 0;
    public ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String firstName, String lastName, String phone, String address) {
        ArrayList<String> usedIds = new ArrayList<>();
        for (Contact contact : contacts) {
            usedIds.add(contact.getId());
        }
        while (usedIds.contains(id.toString())) {
            id++;
        }
        Contact contact = new Contact(id.toString(), firstName, lastName, phone, address);
        contacts.add(contact);
        id++;
    }

    public void deleteContact(String id) {
        int index = -1;
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                index = contacts.indexOf(contact);
            }
        }
        if (index == -1) {
            System.out.println("Contact not found");
        } else {
            contacts.remove(contacts.get(index));
        }
    }

    public void updateContact(String id, String firstName, String lastName, String phone, String address) {
        int index = -1;
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                index = contacts.indexOf(contact);
            }
        }
        if (index == -1) {
            System.out.println("Contact not found");
        } else {
            contacts.get(index).setFirstName(firstName);
            contacts.get(index).setLastName(lastName);
            contacts.get(index).setPhone(phone);
            contacts.get(index).setAddress(address);
        }
    }
}
