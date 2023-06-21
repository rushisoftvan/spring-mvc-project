

package com.learn.controller;

import com.learn.entity.CategoryEntity;
import com.learn.service.CategoryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping("/showcategories")
    public String showCategories(Model model) {
    	log.debug("<<<<<<<< showCategories()");
    	System.out.println("hey");
    	 List<CategoryEntity> categories = this.categoryService.getCategories();
    	 System.out.println("categories"+categories);
    	 model.addAttribute("categories",categories);
    	 log.debug("showCategories() >>>>>>>>>>");
    	return "categoryList";
    }
   
    
}
