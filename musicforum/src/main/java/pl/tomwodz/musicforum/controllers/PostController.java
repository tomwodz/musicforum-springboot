package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.services.IPostService;
import pl.tomwodz.musicforum.services.ITopicService;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@RequestMapping(path="/forum/topic/post")
public class PostController {
    @Resource
    SessionData sessionData;
    private  final IPostService postService;
    private final ITopicService topicService;

    public PostController(IPostService postService, ITopicService topicService) {
        this.postService = postService;
        this.topicService = topicService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable int id, Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("topic", this.topicService.getTopicById(id));
        model.addAttribute("postsOfTopicId", this.postService.gelAllPostsOfTopic(id));
        return "post";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public String addPost(@PathVariable int id, @ModelAttribute Post post, Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        postService.persistPostOfTopic(id, post, sessionData.getUser());
        return "redirect:/forum/topic/post/{id}";
    }

    @RequestMapping(path = "delete/{idTopic}/{idPost}", method = RequestMethod.GET)
    public String deletePost(@PathVariable int idTopic, @PathVariable int idPost, Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        if (!this.sessionData.isAdmin()) {
            return "redirect:/forum/topic/post/{idTopic}";
        }
        this.postService.deletePost(idTopic, idPost);
        return "redirect:/forum/topic/post/{idTopic}";
    }
}
