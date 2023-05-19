package com.t5.enactest_t5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnactestT5Controller {

    @GetMapping("/index")
    public String pagina_iniziale()
    {
        return "menuprincipale";
    }
    
}
