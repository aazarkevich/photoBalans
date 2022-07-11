package photoBalans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import photoBalans.service.BeeService;

@Controller
@RequestMapping("/")
public class BeeController {
    private BeeService beeService;

    @Autowired
    public BeeController(BeeService beeService) {
        this.beeService = beeService;
    }

    @GetMapping()
    public String readValues() {
        return "main/index";
    }

    @GetMapping("/find")
    public String findValues(@RequestParam("selectFind") String selectFind,
                             @RequestParam("find") String find, Model model) {
        model.addAttribute("beeFList", beeService.findDeviceBeef(selectFind, find.trim()));
        model.addAttribute("dataPhotoList", beeService.findDeviceDataPhoto(selectFind, find.trim()));
        return "main/values";
    }
}
