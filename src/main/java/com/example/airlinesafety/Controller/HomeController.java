package com.example.airlinesafety.Controller;

import com.example.airlinesafety.Servvice.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    DataService data;

    @GetMapping (value = "/home")
    public String getHome(Model model) {
        model.addAttribute("data", data.getAirLineList());
        return "home"; //html file
    }

}
