package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tomwodz.musicforum.exception.LoginAlreadyExistException;
import pl.tomwodz.musicforum.exception.UserValidationException;
import pl.tomwodz.musicforum.model.User;
import pl.tomwodz.musicforum.services.IAuthenticationService;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@RequestMapping(path = "/view")
public class AuthenticationViewController {

    @Resource
    SessionData sessionData;

    private final IAuthenticationService authenticationService;

    public AuthenticationViewController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(path="/login", method = RequestMethod.GET)
    public String login(Model model
    ){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        return "login";
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password){
        try {
            this.authenticationService.authenticate(login, password);
            if(sessionData.isLogged()){
                return "redirect:/view/forum";
            }
        }
        catch (UserValidationException e){}
        return "redirect:/view/login";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(){
        this.authenticationService.logout();
        return "redirect:/view/forum";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("logged", this.sessionData.isLogged());
        model.addAttribute("userModel", new User());
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, @RequestParam String password2){
        try {
            //UserValidator.validateUser(user); //TODO
            //UserValidator.validatePasswordsEquality(user.getPassword(), password2);
            user.setRole(User.Role.USER); //TODO
            this.authenticationService.register(user);
        } catch (LoginAlreadyExistException | UserValidationException e){
            return "redirect:/view/register";
        }
        return "redirect:/view/login";
    }

}