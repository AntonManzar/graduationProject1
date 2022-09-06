package graduationProject.controllers;

import graduationProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String showListProduct(Model model) {
        model.addAttribute("listProduct", productService.showListProduct());

        return "product/showListProduct";
    }

    @GetMapping("/test")
    public String test(){
        return "/test";
    }
}
