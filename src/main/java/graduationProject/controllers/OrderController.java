package graduationProject.controllers;

import graduationProject.security.PersonDetails;
import graduationProject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showListOrders(Model model) {
        model.addAttribute("listOrders" , orderService.showListOrders(PersonDetails.getPersonAuth()));

        return "order/showListOrders";
    }
}
