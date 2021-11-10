package com.nurd.assigment.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageNotFoundHandler implements ErrorController {
//    @Override
//    public String getErrorPath() {
//        return null;
//    }

    @RequestMapping("/error")
    public String handleError() {
        return "index.html";
    }
}
