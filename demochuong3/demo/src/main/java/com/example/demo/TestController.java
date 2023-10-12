package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/todo")
    @ResponseBody
    public String handleGetMethod() {
        return "get to do";
    }

    @PostMapping("/todo")
    @ResponseBody
    public String handlePost(@RequestBody Todo todo) {

        return todo.toString();
    }
}

