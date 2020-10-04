package com.fmont.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

        @RequestMapping({"/owner","/owner/index.html","/owner/index"})
        public String getIndex() {
            return "/owner/index";
        }

}
