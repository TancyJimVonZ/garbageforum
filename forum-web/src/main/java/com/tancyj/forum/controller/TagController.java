package com.tancyj.forum.controller;

import com.tancyj.forum.domain.Tag;
import com.tancyj.forum.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private ITagService tagService;

    @RequestMapping("/findall.do")
    public ModelAndView findall() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Tag> tags = tagService.findAll();

        mv.addObject("tags",tags);
        mv.setViewName("tag-list");
        return mv;
    }


    @RequestMapping("/savetag.do")
    public String addtag(Tag tag) throws Exception {
        tagService.addtag(tag);
        return "redirect:findall.do";
    }

    @RequestMapping("/deltag.do")
    public String deltag(Integer tag_id) throws Exception {
        tagService.deltag(tag_id);
        return "redirect:findall.do";
    }


    @RequestMapping("/updatetag.do")
    public String updateuser(Tag tag) throws Exception {
        tagService.updatetag(tag);
        return "redirect:findall.do";
    }

    @RequestMapping("/taginfo.do")
    public ModelAndView userinfo(Integer tag_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Tag tag = tagService.findById(tag_id);
        mv.addObject("tag",tag);
        mv.setViewName("tag-show");
        return mv;
    }
    
}
