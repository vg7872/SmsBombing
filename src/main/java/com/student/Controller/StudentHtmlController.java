package com.student.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentHtmlController {

    @PostMapping("/student")
    public String studentHtml(){
        return "vaskar";
    }
}
