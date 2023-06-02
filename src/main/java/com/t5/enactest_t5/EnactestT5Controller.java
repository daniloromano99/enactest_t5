package com.t5.enactest_t5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class EnactestT5Controller {

    @GetMapping("/index")
    public String pagina_iniziale(Model Model)
    {
        return "menuprincipale";
    }
    
    @GetMapping("/mainmenu")
    public String seconda_pagina(Model Model)
    {
        return "menuprincipalept2";
    }

    @GetMapping("/chooseclass")
    public String choose_class(Model Model)
    {
        return "choose_class";
    }

    @GetMapping("/chooserobot")
    public String choose_robot(Model Model)
    {
        return "choose_robot";
    }

    //choose difficulty eventuale

    @GetMapping("/edit")
    public String ambientediediting(Model Model)
    {
        return "ambientediediting";
    }
    
}
