package com.springboot.bikeforrent.controller;

import com.springboot.bikeforrent.entity.Owner;
import com.springboot.bikeforrent.repository.OwnerRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OwnerController {


    @Autowired
    private OwnerRepository oRepo;


    @GetMapping({"/"})
    public ModelAndView showLandingPage(){
        ModelAndView mav = new ModelAndView("index");
        return  mav;
    }
    @GetMapping({"/updateDelete"})
    public ModelAndView showUpdateDeleteForm(@RequestParam Long ownerId) {
        ModelAndView mav = new ModelAndView("add-owner-form");
        Owner owner = oRepo.findById(ownerId).get();
        mav.addObject("owner", owner);
        return mav;
    }

    @GetMapping({"/showOwner","/list"})
    public ModelAndView showOwner(){
        ModelAndView mav = new ModelAndView("list-owner");
        List<Owner> list=oRepo.findAll();
        mav.addObject("owners",list);
        return  mav;

    }
    @GetMapping("/addOwnerForm")
    public ModelAndView addOwnerForm(){
        ModelAndView mav = new ModelAndView("add-owner-form");
        Owner newOwner = new Owner();
        mav.addObject("owner",newOwner);
        return  mav;
    }
    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute Owner owner){
        oRepo.save(owner);
        return "redirect:/list";
    }
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long ownerId){
        ModelAndView mav =  new ModelAndView("update");
        Owner owner = oRepo.findById(ownerId).get();
        mav.addObject("owner",owner);
        return mav;
    }
    @GetMapping("/deleteOwner")
    public String deleteOwner(@RequestParam Long ownerId){
        oRepo.deleteById(ownerId);
        return "redirect:/list";
    }



}
