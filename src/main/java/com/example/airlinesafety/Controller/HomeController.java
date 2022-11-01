package com.example.airlinesafety.Controller;

import com.example.airlinesafety.Servvice.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @Autowired
    DataService data;

    //trying to fix this
    @RequestMapping("/error")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping (value = "/home")
    public String getHome(Model model) {
        model.addAttribute("data", data.getAirLineList());
        return "home"; //html file
    }

}
