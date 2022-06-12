package photoBalans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import photoBalans.dao.BeeFImpl;
import photoBalans.models.BeeF;
import photoBalans.service.BeeService;

import java.util.List;

@Controller
@RequestMapping("/")
public class BeeController {

    @Autowired
    private BeeService beeService;
    @Autowired
    private BeeFImpl beeF;

    @GetMapping()
    public String readValues() {
        return "main/index";
    }

    @GetMapping("/find")
    public String findValues(@RequestParam("selectFind") String selectFind,
                             @RequestParam("find") String find, Model model) {
//        List<BeeF> numberDevice = beeService.findDevice(selectFind, find.trim());
        model.addAttribute("valuesList",beeService.findDevice(selectFind, find.trim()));
//        for (BeeF beeF : numberDevice) {
//            System.out.println(beeF);
//        }

        return "main/values";
    }
}
