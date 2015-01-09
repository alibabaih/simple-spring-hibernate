package ru.liwest.contactmaneger.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.liwest.contactmaneger.domain.Contact;
import ru.liwest.contactmaneger.service.ContactService;

import java.util.Map;

/*
Аннотация используется для магического превращения любого java класса в класс контроллера.
Данный класс представляет собой компонент, похожий на обычный сервлет (HttpServlet) (работающий с объектами HttpServletRequest и HttpServletResponse), но с расширенными возможностями по применению в MVC-приложениях.
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    /*
    Аннотация используется для маппинга урл-адреса запроса на указанный метод или класс. Запрос можно маппить как на метод класса, так и на целый класс. Допускается указывать конкретный HTTP-метод, который будет обрабатываться (GET/POST), передавать параметры запроса.
     */
    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
        map.put("contact", new Contact());
        map.put("contactList", contactService.listContact());

        return "contact";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    /*
    Аннотация, связывающая параметр метода или возвращаемое значение метода с атрибутом модели, которая будет использоваться при выводе jsp-страницы.
     */
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
        contactService.addContact(contact);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{contactId}")
    /*
    Аннотация, которая показывает, что параметр метода должен быть связан с переменной из урл-адреса.
     */
    public String deleteContact(@PathVariable("contactId") Integer contactId) {
        contactService.removeContact(contactId);

        return "redirect:/index";
    }
}
