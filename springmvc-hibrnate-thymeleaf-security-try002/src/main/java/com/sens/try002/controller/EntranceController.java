package com.sens.try002.controller;

import com.sens.try002.model.Comment;
import com.sens.try002.model.Entrance;
import com.sens.try002.service.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Sensible on 09.12.2017.
 */

@Controller
public class EntranceController {

    @Autowired
    private EntranceService entranceService;

//    @Autowired
//    private CommentService commentService;

    @RequestMapping(value = "/entrance/{id}", method = RequestMethod.GET)
    public String openComments(@PathVariable long id, Model model, BindingResult result) {
        Entrance entrance = entranceService.findByIdWithComments(id);
        Comment comment = new Comment();

        if (entrance.getComments().size() > 0) {
            List<Comment> comments = entrance.getComments();
            model.addAttribute("comments", comments);
        } else {
            model.addAttribute("comments", null);
        }

        model.addAttribute("comment", comment);
        model.addAttribute("entrance", entrance);

        return "comments";
    }

    @RequestMapping(value = "/entrance/{id}", method = RequestMethod.POST)
    public String addComments(@PathVariable long id, @ModelAttribute("comment") Comment comment, Model model) {
        Entrance entrance = entranceService.findByIdWithComments(id);

        if (comment.getMessage() != null) {
//            Long commentId = commentService.count();
//            comment.setId(++commentId);
            entrance.addComment(comment);
            entranceService.save(entrance);
        }

        if (entrance.getComments().size() > 0) {
            List<Comment> comments = entrance.getComments();
            model.addAttribute("comments", comments);
        } else {
            model.addAttribute("comments", null);
        }

        model.addAttribute("entrance", entrance);
        return "comments";
    }
}
