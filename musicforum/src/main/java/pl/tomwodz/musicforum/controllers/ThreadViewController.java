package pl.tomwodz.musicforum.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomwodz.musicforum.services.IPostRetriever;
import pl.tomwodz.musicforum.session.SessionData;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/view/forum/topic/thread/")
public class ThreadViewController {

    @Resource
    SessionData sessionData;

    private final IPostRetriever postRetriever;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getTread(Model model, @PathVariable Long id){
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("postsByThreadId", this.postRetriever.findByThreadId(id));
        return "thread";
    }

}
