package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HelloController {
    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello, Root!";
    }
//    @GetMapping("hello")
//    public String hello2() {
//        return "Hello, Spring!";
//    }
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //create a handler that handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
//        switch (language) {
//            case "english":
//                return "<html style='background-color:blue'>" +
//                        "<h1 style='color:red'>" +
//                        "Hello, " + name + "!" +
//                        "</h1>" +
//                        "</html>";
//
//            case "french":
//                return "<html style='background-color:blue'>" +
//                        "<h1 style='color:white'>" +
//                        "Bonjour, " + name + "!" +
//                        "</h1>" +
//                        "</html>";
//
//            case "spanish":
//                return "<html style='background-color:red'>" +
//                        "<h1 style='color:yellow'>" +
//                        "Hola, " + name + "!" +
//                        "</h1>" +
//                        "</html>";
//
//            case "dutch":
//                return "<html style='background-color:orange'>" +
//                        "<h1 style='color:blue'>" +
//                        "Hallo, " + name + "!" +
//                        "</h1>" +
//                        "</html>";
//
//            case "british":
//                return "<html style='background-image:url(https://i.kym-cdn.com/entries/icons/medium/000/039/603/cover8.jpg)'>" +
//                        "<h1 style='color:white'>" +
//                        "OI GUVNA YOO MUST BE " + name.toUpperCase() + ", INNIT?!" +
//                        "</h1>" +
//                        "</html>";
//
//            default:
//                return "You broke the switch statement";
//        }
//        return "Hello, " + name + "!";
//    }

    //thymeleaf demo video follow along method
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }
    @GetMapping("hello/{name}")
//    @ResponseBody
    public String helloPath(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" +
//                "<input type='text' name='name'>" +
//                "<select name='language'>" +
//                "<option value='english'> English </option>" +
//                "<option value='french'> French </option>" +
//                "<option value='spanish'> Spanish </option>" +
//                "<option value='dutch'> Dutch </option>" +
//                "<option value='british'> British </option>" +
//                "</select>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Matt");
        names.add("Creek");
        model.addAttribute("names", names);
        return "hello-list";
    }


}
