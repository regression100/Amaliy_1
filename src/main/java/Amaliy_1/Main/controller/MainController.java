package Amaliy_1.Main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/amaliy_1")
    public String amaliy_1(){
        return "amaliy_1";
    }

    @GetMapping("/poker")
    public String poker(){
        return "poker";
    }

}
