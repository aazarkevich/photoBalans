package photoBalans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import photoBalans.service.BeeService;

@Controller
@RequestMapping("/login")
public class AutorizationController {
    @Autowired
    private BeeService beeService;

    @GetMapping()
    public String login() {
        return "autorization/login.html";
    }

    @GetMapping("/logout")
    public String logout() {
//        beeService.setBeeF(null);
        return "redirect:/login.html";
    }



}
