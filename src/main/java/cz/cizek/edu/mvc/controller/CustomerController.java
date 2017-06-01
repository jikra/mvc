package cz.cizek.edu.mvc.controller;

import cz.cizek.edu.mvc.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiricizek <jiri.cizek@cleverlance.com>
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String customer(@SessionAttribute("customer") Customer customer,
                           @RequestHeader("Connection") String language,
                           @CookieValue("JSESSIONID") String sessionId) {

        System.out.println("lang: " + language);
        System.out.println("jsessionID: " + sessionId);
        return "home";
    }

    @RequestMapping(path = "/ex", method = RequestMethod.GET)
    public String ex() {

        throw new ClassCastException();

//        return "home";
    }

    @ExceptionHandler(ClassCastException.class)
    public String handleEx() {

        return "errorPage";
    }
}
