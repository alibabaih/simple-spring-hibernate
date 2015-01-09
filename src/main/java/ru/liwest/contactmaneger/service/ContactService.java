package ru.liwest.contactmaneger.service;

import ru.liwest.contactmaneger.domain.Contact;

import java.util.List;

public interface ContactService {

    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);

}
