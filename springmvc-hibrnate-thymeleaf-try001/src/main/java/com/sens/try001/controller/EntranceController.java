package com.sens.try001.controller;

import com.sens.try001.model.Comment;
import com.sens.try001.model.Entrance;
import com.sens.try001.service.interfaces.CommentService;
import com.sens.try001.service.interfaces.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Sensible on 07.11.2017.
 */

@Controller
public class EntranceController {

    @Autowired
    private EntranceService entranceService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/findEntrance/{id}/comments", method = RequestMethod.GET)
    public String openComments(@PathVariable long id, Model model) {
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

    @RequestMapping(value = "/findEntrance/{id}/comments", method = RequestMethod.POST)
    public String addComments(@PathVariable long id, @ModelAttribute("comment") Comment comment, Model model) {
        Entrance entrance = entranceService.findByIdWithComments(id);

        if (comment.getMessage() != null) {
            Long commentId = commentService.count();
            comment.setId(++commentId);
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
