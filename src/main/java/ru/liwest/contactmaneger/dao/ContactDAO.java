package ru.liwest.contactmaneger.dao;


import ru.liwest.contactmaneger.domain.Contact;
import java.util.List;

public interface ContactDAO { //practice realization object access to data

    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);

}
