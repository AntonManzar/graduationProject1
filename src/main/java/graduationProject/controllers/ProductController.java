package graduationProject.controllers;

import graduationProject.models.Basket;
import graduationProject.models.Product;
import graduationProject.security.PersonDetails;
import graduationProject.services.BasketService;
import graduationProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final BasketService basketService;

    @Autowired
    public ProductController(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;
    }

    @GetMapping()
    public String showListProduct(Model model, @ModelAttribute("addBasket") Basket basket) {
        model.addAttribute("listProduct", productService.showListProduct());
        model.addAttribute("basket", basketService.showBasketWithProducts(PersonDetails.getPersonAuth()));
        return "product/showListProduct";
    }

    @GetMapping("/{productId}")
    public String showProduct(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product" , productService.showProduct(productId));
        model.addAttribute("roleAdmin", PersonDetails.getPersonAuth().getPersonRole().equals("ROLE_ADMIN"));
        return "product/showProduct";
    }

    @GetMapping("/createNewProduct")
    public String createNewProduct(@ModelAttribute("product") Product product) {

        return "product/createNewProduct";
    }

    @PostMapping()
    public String createNewProductPost(@ModelAttribute("product") Product product){

        productService.createNewProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/{productId}/editProduct")
    public String editProductGet(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product", productService.showProduct(productId));

        return "product/editProduct";
    }

    @PatchMapping("/{productId}")
    public String editProductPatch(@ModelAttribute("product") @Valid Product product, @PathVariable("productId") int productId) {

        productService.editProduct(productId, product);

        return "redirect:/product";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId) {
        productService.deleteProduct(productId);
        return "redirect:/product";
    }

}
