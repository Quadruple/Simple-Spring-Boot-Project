package io.javabrains.springbootstarter.hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Tells that this class is a rest service controller
public class HelloController {

    @RequestMapping("/hello") // This gives response when the url includes /hello ex : localhost:8080/hello
    public String sayHi() {

        return "Hi Yo !" ;

    }

}
