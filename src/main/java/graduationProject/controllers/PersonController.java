package graduationProject.controllers;

import graduationProject.models.Person;
import graduationProject.security.PersonDetails;
import graduationProject.services.PersonService;
import graduationProject.utils.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final PersonValidator personValidator;

    @Autowired
    public PersonController(PersonService personService, PersonValidator personValidator) {
        this.personService = personService;
        this.personValidator = personValidator;
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
        model.addAttribute("user", PersonDetails.getPersonAuth());

        return "person/showUserInfo";
    }

    @GetMapping("/createNewPerson")
    public String createNewPerson(@ModelAttribute("person") Person person) {

        return "person/createNewPerson";
    }

    @PostMapping
    public String createPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) return "person/createNewPerson";

        personService.createNewPerson(person);

        return "redirect:/person";
    }

    @GetMapping("/{person_id}/editPerson")
    public String editPersonGet(@PathVariable("person_id") int personId, Model model) {
        model.addAttribute("person", personService.showPersonById(personId));

        return "person/editPerson";
    }

    @PatchMapping("/{person_id}")
    public String editPersonPatch(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                                  @PathVariable("person_id") int personId) {

        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) return "person/editPerson";

        personService.editPerson(personId, person);

        return "redirect:/";
    }

    @DeleteMapping("/{person_id}")
    public String deletePerson(@PathVariable("person_id") int personId) {
        personService.deletePerson(personId);
        return "redirect:/logout";
    }

}
