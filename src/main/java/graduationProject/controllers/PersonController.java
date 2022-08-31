package graduationProject.controllers;

import graduationProject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping
    public String showListPerson(Model model, HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getQueryString());
        model.addAttribute("listPerson", personService.showListPerson());
        return "person/showListPerson";
    }
}
