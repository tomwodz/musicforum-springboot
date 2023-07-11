package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomwodz.musicforum.services.ITopicRetriever;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/view")
public class ForumViewController {

    @Resource
    SessionData sessionData;

    private final ITopicRetriever topicRetriever;

    @RequestMapping(path = "/forum", method = RequestMethod.GET)
    public String main(Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("topics", this.topicRetriever.findAll());
        return "forum";
    }

}
