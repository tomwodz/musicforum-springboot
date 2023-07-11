package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomwodz.musicforum.services.ITopicService;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
public class CommonController {

    @Resource
    SessionData sessionData;

    private final ITopicService topicService;

    public CommonController(ITopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(path = {"/", "/main"}, method = RequestMethod.GET)
    public String main(Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        return "index";
    }

}
