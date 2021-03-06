package com.endava.books.endavabooks.controller;

import com.endava.books.endavabooks.service.AuthorService;
import com.endava.books.endavabooks.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class EndavaBooksController {

    @GetMapping(path = "/greetings")
    @ResponseBody
    public String greetings(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

}
