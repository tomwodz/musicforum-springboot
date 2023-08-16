package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.User;
import pl.tomwodz.musicforum.services.IForumAdder;
import pl.tomwodz.musicforum.services.IForumDeleter;
import pl.tomwodz.musicforum.services.IForumRetriever;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/view/forum/topic/thread/post")
@Log4j2
public class PostViewController {

    @Resource
    SessionData sessionData;

    private final IForumRetriever forumRetriever;
    private final IForumAdder forumAdder;
    private final IForumDeleter forumDeleter;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getPostsByIdTread(Model model, @PathVariable Long id){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("postsByThreadId", this.forumRetriever.findPostByThreadId(id));
        model.addAttribute("postModel", new Post());
        return "post";
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
                this.forumAdder.addPost(postToSave);
                //model.addAttribute("info_message", "Dodano post do wątku.");
                //return "info_message";
            } catch (Exception e) {
                model.addAttribute("info_message", "Błąd.");
                return "info_message";
            }
        }
        model.addAttribute("postsByThreadId", forumRetriever.findPostByThreadId(id));
        model.addAttribute("postModel", new Post());
        return "post";
    }

    @GetMapping(path = "/delete/{id}")
    public String deletePostById(Model model, @PathVariable Long id){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        try{
            this.forumDeleter.deletePostById(id);
            model.addAttribute("info_message", "Usunięto post o id: " + id);
            return "info_message";
        } catch (Exception e){
            model.addAttribute("info_message", "Błąd.");
            return "info_message";
        }
    }

}