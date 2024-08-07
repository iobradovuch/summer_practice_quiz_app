package ua.iobradovuch.quiz.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.iobradovuch.quiz.dataservice.UserDTO;
import ua.iobradovuch.quiz.service.UserServiceImpl;

@Controller
public class UserController {
    private UserServiceImpl userDetailsService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    public UserController(UserServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/")
    private String getIndex() {
        return "index";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "signup";
    }

    @PostMapping("/usersignup")
    public String signupProcess(@Valid @ModelAttribute ("userDTO") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String operation = "signed up with";
        String entityType = "new account";
        if(bindingResult.hasErrors()) {
            System.out.println("We encountered an error signing up!");
            return "sign-up";
        }
        userDetailsService.createUserMap(userDTO);
        redirectAttributes.addFlashAttribute("operation", operation);
        redirectAttributes.addFlashAttribute("entitytype", entityType);
        return "redirect:/successpage";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = { "/home","/index" } )
    public String getHomePage() {
        return "index";
    }
}
