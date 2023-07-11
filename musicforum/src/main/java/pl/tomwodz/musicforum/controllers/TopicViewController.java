package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tomwodz.musicforum.services.IThreadRetriever;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@RequestMapping(path = "/view/forum/topic")
@AllArgsConstructor
public class TopicViewController {
    @Resource
    SessionData sessionData;

    private final IThreadRetriever threadRetriever;

    @GetMapping(path = "/{id}")
    public String getTopic(Model model, @PathVariable Long id){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("threadsByTopicId", this.threadRetriever.findByTopicId(id));
        return "topic";
    }

}
