package ru.liwest.contactmaneger.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.liwest.contactmaneger.domain.Contact;

import java.util.List;

@Repository
/*
Annotation shows that class functioning as repository and requires
transparent translation exceptions. The advantage of the translation
the exceptions is that, that service layer will be dealt with common
 hierarchy exceptions by the Spring (DataAccessException) independent
 from using access data technologies in DAO layer.
 */
public class ContactDAOImpl implements ContactDAO {

    /*
    Annotation allow automatically set value of the field SessionFactory
     */
    @Autowired
    private SessionFactory sessionFactory; //SessionFactory by hibernate

    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @SuppressWarnings("unchecked")
    public List<Contact> listContact() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    public void removeContact(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
    }

}
