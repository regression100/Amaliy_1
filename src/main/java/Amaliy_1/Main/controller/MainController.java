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



    @GetMapping("/hill")
    public String hill(){
        return "hill";
    }


    @GetMapping("/beam")
    public String beam(){
        return "beam";
    }

    @GetMapping("/optimal")
    public String optimal(){
        return "optimal";
    }

    @GetMapping("/game15")
    public String game15(){
        return "game15";
    }

    @GetMapping("/maze")
    public String maze(){
        return "alpha_beta_maze";
    }

    @GetMapping("/ocr")
    public String ocr(){
        return "ocr";
    }





    @GetMapping("/ml")
    public String ml(){
        return "ml";
    }

    @GetMapping("/yakuniy")
    public String yakuniy(){
        return "puzzle8";
    }

}
