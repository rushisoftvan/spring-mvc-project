package com.learn.controller;

import com.learn.entity.CategoryEntity;
import com.learn.entity.ProductEntity;
import com.learn.enums.StatusEnum;
import com.learn.service.CategoryService;
import com.learn.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/add")
    public String addCategory(Model model) {
        List<CategoryEntity> categories = this.categoryService.getCategories();
        ProductEntity productEntity = new ProductEntity();
        model.addAttribute("product", productEntity);
        model.addAttribute("categories", categories);
        return "addProductForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") ProductEntity productEntity) {
        log.debug("<<<<<<<< save()");
        log.debug("Product Name : {}", productEntity.getName());
        log.debug("Product price : {}", productEntity.getPrice());
        log.debug("Product category : {}", productEntity.getCategory());
        this.productService.save(productEntity);
        log.info("Product saved successfully with id :: {} ", productEntity.getId());

        log.debug("save() >>>>>>>>>>");
        return "redirect:all";
    }

    @RequestMapping("/all")
    public String getProducts(Model model) {
        List<ProductEntity> products = this.productService.getProducts();
        model.addAttribute("products", products);
        return "productsList";
    }

    @RequestMapping("/editPage/{id}")
    public String showEditPage(@PathVariable("id") Integer productId, Model model) {
        log.debug("<<<<<<< showEditPage()");
        log.debug("Updated product id :: {}", productId);

        StatusEnum[] statusList = StatusEnum.values();

        ProductEntity productEntity = this.productService.getProduct(productId);
        List<CategoryEntity> categories = this.categoryService.getCategories();

        model.addAttribute("product", productEntity);
        model.addAttribute("categories", categories);
        model.addAttribute("statusList", statusList);
        log.debug("showEditPage() >>>>>>>>");
        return "editProductForm";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("product") ProductEntity productEntity) {
        log.debug("<<<<<<<< update()");
        log.debug("Product id :: {}" , productEntity.getId());
        log.debug("Product Name : {}", productEntity.getName());
        log.debug("Product price : {}", productEntity.getPrice());
        log.debug("Product category : {}", productEntity.getCategory());
        log.debug("Product status :: {}" , productEntity.getActiveStatus());
        this.productService.update(productEntity);
        log.info("Product updated successfully with id :: {} ", productEntity.getId());

        log.debug("update() >>>>>>>>>>");

        return "redirect:all";
    }


}
