package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.model.User;
import pl.tomwodz.musicforum.services.IThreadRetriever;
import pl.tomwodz.musicforum.services.ITopicAdder;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@RequestMapping(path = "/view/forum/topic")
@AllArgsConstructor
@Log4j2
public class TopicViewController {
    @Resource
    SessionData sessionData;

    private final IThreadRetriever threadRetriever;
    private final ITopicAdder topicAdder;

    @GetMapping(path = "/{id}")
    public String getTopic(Model model, @PathVariable Long id) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("threadsByTopicId", this.threadRetriever.findByTopicId(id));
        return "topic";
    }

    @GetMapping(path = "/add")
    public String getTopicToAdd(Model model) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("topicModel", new Topic());
        return "add-topic";
    }

    @PostMapping(path = "/add")
    public String addTopic(Model model, @ModelAttribute Topic topic) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        if (!topic.getTitle().equals("")) {
            try {
                topic.setAuthor(new User(sessionData.getUser().getId()));
                this.topicAdder.addTopic(topic);
                model.addAttribute("info_message", "Dodano temat do forum.");
                return "info_message";
            } catch (Exception e) {
                model.addAttribute("info_message", "Błąd.");
                return "info_message";
            }
        }
        model.addAttribute("topicModel", new Topic());
        return "add-topic";
    }


}




