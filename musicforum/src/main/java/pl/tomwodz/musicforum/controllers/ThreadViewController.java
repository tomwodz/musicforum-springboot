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
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/view/forum/thread")
@Log4j2
public class ThreadViewController {

    @Resource
    SessionData sessionData;

    private final IForumAdder forumAdder;
    private final IForumDeleter forumDeleter;

    @GetMapping(path = "/add/{topicId}")
    public String getThreadToAdd(Model model, @PathVariable Long topicId) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("threadModel", new Thread(topicId));
        return "add-thread";
    }

    @PostMapping(path = "/add/{topic}")
    public String addThread(Model model, @ModelAttribute Thread thread) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        if (!thread.getTitle().equals("")) {
            try {
                thread.setAuthor(new User(sessionData.getUser().getId()));
                this.forumAdder.addThread(thread);
                model.addAttribute("info_message", "Dodano wątek do tematu.");
                return "info_message";
            } catch (Exception e) {
                model.addAttribute("info_message", "Błąd.");
                return "info_message";
            }
        }
        model.addAttribute("add-threadModel", new Topic());
        return "add-thread";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteThreadById(Model model, @PathVariable Long id){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        try{
            this.forumDeleter.deleteThreadByIdAndDeletePostsByThreadId(id);
            model.addAttribute("info_message", "Usunięto wątek z tematu.");
            return "info_message";
        } catch (Exception e){
            model.addAttribute("info_message", "Błąd.");
            return "info_message";
        }
    }

}
