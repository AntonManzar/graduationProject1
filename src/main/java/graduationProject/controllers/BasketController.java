package graduationProject.controllers;

import graduationProject.models.Basket;
import graduationProject.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basket")
public class BasketController {

    public final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    public String showAddBasket() {
        return "product/showListProduct";
    }

    @PostMapping
    public String addBasket(@ModelAttribute("addBasket") Basket basket) {
        return "product/showListProduct";
    }
}
