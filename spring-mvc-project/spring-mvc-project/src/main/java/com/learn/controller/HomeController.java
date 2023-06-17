package com.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class HomeController {

    private Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/status")
    public String status(){
        log.info("<<<<<<<< start() Changed");
        log.info("start() >>>>>>");
        return "status";
    }

}
