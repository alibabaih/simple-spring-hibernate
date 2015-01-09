package ru.liwest.contactmaneger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liwest.contactmaneger.dao.ContactDAO;
import ru.liwest.contactmaneger.domain.Contact;

import java.util.List;

/*
Мы используем данную аннотацию, чтобы объявить,
что этот класс представляет сервис – компонент
сервис-слоя. Сервис является подтипом класса @Component.
Использование данной аннотации позволит искать
бины-сервисы автоматически (смотрите далее в root-context.xml).
 */
@Service
public class ContactServiceImpl {

    @Autowired
    private ContactDAO contactDAO;

    /*
    Перед исполнением метода помеченного данной аннотацией
    начинается транзакция, после выполнения метода транзакция
    коммитится, при выбрасывании RuntimeException откатывается.
     */
    @Transactional //add dependency in pom.xml
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Transactional
    public List<Contact> listContact() {
        return contactDAO.listContact();
    }

    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }

}
