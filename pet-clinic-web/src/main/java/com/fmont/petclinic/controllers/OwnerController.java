package com.fmont.petclinic.controllers;

import com.fmont.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owner", "/owner/index.html", "/owner/index"})
    public String getIndex(Model model) {

        model.addAttribute("owners", ownerService.findAll());
        return "/owner/index";
    }

}
