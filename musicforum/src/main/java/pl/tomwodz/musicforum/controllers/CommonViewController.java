package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@AllArgsConstructor
public class CommonViewController {

    @Resource
    SessionData sessionData;

    @RequestMapping(path = {"/", "/main"}, method = RequestMethod.GET)
    public String main(Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        return "index";
    }

}
