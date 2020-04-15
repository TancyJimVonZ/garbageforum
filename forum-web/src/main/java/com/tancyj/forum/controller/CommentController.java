package com.tancyj.forum.controller;

import com.tancyj.forum.domain.Comment;
import com.tancyj.forum.service.ICommentService;
import com.tancyj.forum.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @RequestMapping("/findall.do")
    public ModelAndView findall() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Comment> comments = commentService.findAll();
        mv.addObject("comments",comments);
        mv.setViewName("comment-list");
        return mv;
    }


    @RequestMapping("/savecomment.do")
    public String addcomment(Comment comment) throws Exception {
        System.out.println(comment);
        commentService.addcomment(comment);
        return "redirect:findall.do";
    }

    @RequestMapping("/delcomment.do")
    public String delcomment(Integer cid) throws Exception {
        commentService.delcomment(cid);
        return "redirect:findall.do";
    }


    @RequestMapping("/updatecomment.do")
    public String updateuser(Comment comment) throws Exception {
        commentService.updatecomment(comment);
        return "redirect:findall.do";
    }

    @RequestMapping("/commentinfo.do")
    public ModelAndView userinfo(Integer cid) throws Exception {
        ModelAndView mv = new ModelAndView();
        Comment comment = commentService.findById(cid);
        mv.addObject("comment",comment);
        mv.setViewName("comment-show");
        return mv;
    }
}
