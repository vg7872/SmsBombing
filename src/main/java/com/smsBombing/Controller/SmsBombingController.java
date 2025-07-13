package com.smsBombing.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SmsBombingController {

//    @GetMapping(value="/hello-world")
//    @GetMapping("/hello-world")
    @RequestMapping(value = "hello-world", method = RequestMethod.GET)
    public String getHelloWorld(){
        return "Hello World.";
    }

    /**
     * This method is to get concept ot PATH-VARIABLE
     * @PathVariable("name") || {name}: Here , the name is nothing but the path variable. It is used to pass the dynamic value to the controller path.
     * @param nameValue:
     * @return
     */
    @GetMapping("/hello-name/{name}")
    public String getHelloName(@PathVariable("name") String nameValue){
        return "Hello "+nameValue+". Welcome to my page."+" How are u";
    }

    /**
     * This method is to get concept ot REQUEST-PARAM
     * @RequestParam("nameeee"): Here , the name is nothing but the Request param. It is used to pass the dynamic value to the controller param.
     * @param nameValue:
     * @return
     */
    @GetMapping("/how-are-you")
    public String getHowAreYou(@RequestParam("nameeee") String nameValue){
        return "Hello "+nameValue+". How are you.";
    }
}
