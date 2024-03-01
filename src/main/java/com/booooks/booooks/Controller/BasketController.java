package com.booooks.booooks.Controller;

import com.booooks.booooks.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {
    @GetMapping("/basket")
    public String basketOpen(){
        return "basket";
    }
}
