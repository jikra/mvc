package cz.cizek.edu.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author jiricizek <jiri.cizek@cleverlance.com>
 */
@ControllerAdvice(annotations = Controller.class)
public class ControllerGlobalAdvice {

    @ModelAttribute
    public void initModels(Model model) {
        model.addAttribute("version", "2.1.2");
    }

}
