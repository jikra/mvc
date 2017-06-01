package cz.cizek.edu.mvc.controller;

import cz.cizek.edu.mvc.domain.Customer;
import cz.cizek.edu.mvc.formatter.LocalDateFormatter;
import cz.cizek.edu.mvc.validator.CustomerValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

/**
 * @author jiricizek <jiri.cizek@cleverlance.com>
 */
@Controller
@RequestMapping("sample")
@SessionAttributes({"customer"})
public class SampleController {

    @InitBinder("customer")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addCustomFormatter(new LocalDateFormatter());
        webDataBinder.setValidator(new CustomerValidator());
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.status(200).body("Hello");
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> sayHello2Me(
            @PathVariable("name") String name) {
        return ResponseEntity.status(200).body("Hello, " + name);
    }

    @RequestMapping(path = "/sayhello", method = RequestMethod.GET)
    public ResponseEntity<String> sayHello2MeParam(
            @RequestParam("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body("Hello, " + name);
    }

    @RequestMapping(path = "/customer", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Customer getCUstomer() {

        Customer customer = new Customer();
        customer.setName("jikra");
        customer.setAge(30);
        customer.setBirth(LocalDate.now());

        return customer;
    }

    @RequestMapping(path = "/setcustomer", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setCustomer(@RequestBody Customer customer) {

        return ResponseEntity.ok(customer.toString());
    }

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public String setCustomerForm(@Validated @ModelAttribute("customer") Customer customer,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                System.out.println(objectError.getDefaultMessage());
            }
        }

        return "home";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String getHome(@ModelAttribute("customer") Customer customer) {

        //        Customer customer = new Customer();
        //        customer.setName("jikra");
        //        customer.setAge(20);
        //
        //        model.addAttribute("customer", customer);

        return "home";
    }

    @ModelAttribute
    public Customer customer() {
        Customer customer = new Customer();
        customer.setName("jikra");
        customer.setAge(20);
        customer.setBirth(LocalDate.now());

        return customer;
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("uploadFile") List<MultipartFile> multipartFile) {

        for (MultipartFile file : multipartFile) {
            System.out.println(file.getName());
        }

        return "home";
    }
}
