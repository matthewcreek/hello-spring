package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello, Root!";
    }
//    @GetMapping("hello")
//    public String hello2() {
//        return "Hello, Spring!";
//    }
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }
    //create a handler that handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("hello/{name}")
    public String helloPath(@PathVariable String name) {
        return "Hello, " + name + "! How did you get here?";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='english'> English </option>" +
                "<option value='french'> French </option>" +
                "<option value='spanish'> Spanish </option>" +
                "<option value='dutch'> Dutch </option>" +
                "<option value='british'> British </option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
