package com.tancyj.forum.controller;

import com.tancyj.forum.domain.Post;
import com.tancyj.forum.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @RequestMapping("/findall.do")
    public ModelAndView findall() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Post> posts = postService.findAll();

        mv.addObject("posts",posts);
        mv.setViewName("post-list");
        return mv;
    }


    @RequestMapping("/savepost.do")
    public String addpost(Post post) throws Exception {
        postService.addpost(post);
        return "redirect:findall.do";
    }

    @RequestMapping("/delpost.do")
    public String delpost(Integer pid) throws Exception {
        postService.delpost(pid);
        return "redirect:findall.do";
    }


    @RequestMapping("/updatepost.do")
    public String updateuser(Post post) throws Exception {
        postService.updatepost(post);
        return "redirect:findall.do";
    }

    @RequestMapping("/postinfo.do")
    public ModelAndView userinfo(Integer pid) throws Exception {
        ModelAndView mv = new ModelAndView();
        Post post = postService.findById(pid);
        mv.addObject("post",post);
        mv.setViewName("post-show");
        return mv;
    }
}

