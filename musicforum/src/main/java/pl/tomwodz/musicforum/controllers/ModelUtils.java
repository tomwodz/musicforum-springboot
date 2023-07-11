package pl.tomwodz.musicforum.controllers;

import org.springframework.ui.Model;
import pl.tomwodz.musicforum.session.SessionData;

public class ModelUtils {

    public static void addCommonDataToModel(Model model, SessionData sessionData){
        model.addAttribute("logged", sessionData.isLogged());
        model.addAttribute("admin", sessionData.isAdmin());
    }
}
