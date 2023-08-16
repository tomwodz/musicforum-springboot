package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.model.User;
import pl.tomwodz.musicforum.services.IForumAdder;
import pl.tomwodz.musicforum.services.IForumRetriever;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/view/forum/topic/thread")
@Log4j2
public class ThreadViewController {

    @Resource
    SessionData sessionData;

    private final IForumRetriever forumRetriever;
    private final IForumAdder forumAdder;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getTread(Model model, @PathVariable Long id){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("postsByThreadId", this.forumRetriever.findByThreadId(id));
        model.addAttribute("postModel", new Post());
        return "thread";
    }

    @PostMapping(path = "/{id}")
    public String addPost(Model model, @ModelAttribute Post post, @PathVariable Long id) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        if (!post.getContent().equals("")) {
            try {
                Post postToSave = new Post();
                postToSave.setThread(new Thread(id));
                postToSave.setUser(new User(sessionData.getUser().getId()));
                postToSave.setContent(post.getContent());
                Post postSaved = this.forumAdder.addPost(postToSave);
                model.addAttribute("info_message", "Dodano post do wątku.");
                return "info_message";
            } catch (Exception e) {
                model.addAttribute("info_message", "Błąd.");
                return "info_message";
            }
        }
        model.addAttribute("threadModel", this.forumRetriever.findByThreadId(id));
        return "thread";
    }

    @GetMapping(path = "/add/{topicId}")
    public String getTheardToAdd(Model model, @PathVariable Long topicId) {
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

}
