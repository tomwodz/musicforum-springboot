package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.model.User;
import pl.tomwodz.musicforum.services.IForumAdder;
import pl.tomwodz.musicforum.services.IForumDeleter;
import pl.tomwodz.musicforum.services.IForumRetriever;
import pl.tomwodz.musicforum.services.IForumUpdater;
import pl.tomwodz.musicforum.session.SessionData;

import java.util.Optional;

@Controller
@RequestMapping(path = "/view/forum/topic")
@AllArgsConstructor
@Log4j2
public class TopicViewController {
    @Resource
    SessionData sessionData;

    private final IForumRetriever forumRetriever;
    private final IForumAdder forumAdder;
    private final IForumDeleter forumDeleter;
    private final IForumUpdater forumUpdater;

    @GetMapping(path = "/{id}")
    public String getTopic(Model model, @PathVariable Long id) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("threadsByTopicId", this.forumRetriever.findThreadByTopicId(id));
        model.addAttribute("topicId", id);
        return "thread";
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
                this.forumAdder.addTopic(topic);
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

    @GetMapping(path = "/delete/{id}")
    public String deleteTopicById(Model model, @PathVariable Long id) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        try {
            this.forumDeleter.deleteTopicByIdAndThreadsByTopicIdAndDeletePostsByThreadId(id);
            model.addAttribute("info_message", "Usunięto temat");
            return "info_message";
        } catch (Exception e) {
            model.addAttribute("info_message", "Błąd.");
            return "info_message";
        }
    }

    @GetMapping(path = "/update/{id}")
    public String getTopicByIdToUpdate(Model model, @PathVariable Long id) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        Optional<Topic> topicBox = this.forumRetriever.findTopicById(id);
        if (topicBox.isEmpty() || !sessionData.isAdmin()) {
            model.addAttribute("info_message", "Nie znaleziono tematu o id: " + id + " lub nie jesteś adminem.");
            return "info_message";
        }
        model.addAttribute("topicModel", topicBox.get());
        return "add-topic";
    }

    @PostMapping(path = "/update/{id}")
    public String updateThreadById(@ModelAttribute Topic topic, Model model, @PathVariable Long id) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        Topic newTopic = new Topic();
        newTopic.setTitle(topic.getTitle());
        try {
            this.forumUpdater.updateTopicById(id, newTopic);
            model.addAttribute("info_message", "Zaktualizowano temat id: " + id);
            return "info_message";
        } catch (Exception e) {
            model.addAttribute("info_message", "Błąd.");
            return "info_message";
        }
    }
}




