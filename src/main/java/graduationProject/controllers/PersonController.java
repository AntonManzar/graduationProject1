package graduationProject.controllers;

import graduationProject.security.PersonDetails;
import graduationProject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{person_id}")
    public String showPerson(@PathVariable("person_id") int personId, Model model) {
        model.addAttribute("person", personService.showPersonById(personId));

        return "person/showPerson";

    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        model.addAttribute("user", personDetails.getPerson());

        System.out.println(personDetails.getPerson());

        return "person/showUserInfo";
    }
}
