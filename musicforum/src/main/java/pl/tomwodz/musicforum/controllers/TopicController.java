package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.services.IPostService;
import pl.tomwodz.musicforum.services.ITopicService;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@RequestMapping(path = "/forum/topic")
public class TopicController {
    @Resource
    SessionData sessionData;
    private final ITopicService topicService;

    private final IPostService postService;

    public TopicController(ITopicService topicService, IPostService postService) {
        this.topicService = topicService;
        this.postService = postService;
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String viewTopic(Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("topicModel", new Topic());
        model.addAttribute("postModel", new Post());
        return "add-topic";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addTopic(@ModelAttribute Topic topic, @ModelAttribute Post post, Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        int idTopic = this.topicService.persistTopic(topic);
        postService.persistPostOfTopic(idTopic, post, sessionData.getUser());
        return "redirect:/forum";
    }

    @RequestMapping(path = "delete/{id}", method = RequestMethod.GET)
    public String deleteTopic(@PathVariable int id, Model model){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        if (!this.sessionData.isAdmin()) {
            return "redirect:/forum";
        }
        this.topicService.deleteTopic(id);
        return "redirect:/forum";
    }


}
