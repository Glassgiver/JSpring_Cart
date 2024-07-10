package glassgiver.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @GetMapping("/add")
    @ResponseBody
    public String add(@RequestParam int a, @RequestParam int b){
        return String.format("%d + %d = %d", a, b, (a + b));
    }

    @GetMapping("/sub")
    @ResponseBody
    public String sub(){
        return "-1";
    }

    @GetMapping("/div")
    @ResponseBody
    public String div(){
        return "/1";
    }

    @GetMapping("/mul")
    @ResponseBody
    public String mul(){
        return "*1";
    }
}
