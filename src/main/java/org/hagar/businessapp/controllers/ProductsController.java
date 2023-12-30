package org.hagar.businessapp.controllers;

import org.hagar.businessapp.enums.ProductsType;
import org.hagar.businessapp.enums.Size;
import org.hagar.businessapp.model.Product;
import org.hagar.businessapp.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductsController {


    private ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("")
    public ModelAndView getProducts(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productsService.getAll();
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @GetMapping("/addForm")
    public String addProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product",product);
        setEnumAttr(model);
        return "addProduct";
    }
    @GetMapping("/updateForm")
    public String updateProductForm(@RequestParam(name = "productId") int productId, Model model) {
        Product product = productsService.findById(productId);
        model.addAttribute("product",product);
        setEnumAttr(model);
        return "addProduct";
    }

    private  void setEnumAttr(Model model) {
        model.addAttribute("productsType", ProductsType.values());
        model.addAttribute("sizeEnum", Size.values());
    }

    @PostMapping("")
    public String addProduct(@ModelAttribute Product product){
        productsService.addProduct(product);
        return "redirect:/products";
    }


    @GetMapping ("/delete")
    public String deleteProduct(@RequestParam(name = "productId") int productId){
        productsService.deleteProduct(productId);
        return "redirect:/products";
    }
}
