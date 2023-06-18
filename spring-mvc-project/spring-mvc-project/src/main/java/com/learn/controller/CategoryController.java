package com.learn.controller;

import com.learn.entity.CategoryEntity;
import com.learn.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private Logger log = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/add")
    public String addCategory(Model model){
        CategoryEntity categoryEntity = new CategoryEntity();
        model.addAttribute("category" , categoryEntity);
        return "addCategoryForm";
    }

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String save(@ModelAttribute("category") CategoryEntity categoryEntity){
        log.debug("<<<<<<<< save()");
        log.debug("Category Name : {}" , categoryEntity.getName());
        this.categoryService.saveOrUpdate(categoryEntity);
        log.info("Category saved successfully with id :: {} " , categoryEntity.getId());

        log.debug("save() >>>>>>>>>>");
        return "redirect:/";
    }

}
