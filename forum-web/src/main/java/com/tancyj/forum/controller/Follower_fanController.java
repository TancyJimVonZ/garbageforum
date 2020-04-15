package com.tancyj.forum.controller;

import com.tancyj.forum.domain.Follower_fan;
import com.tancyj.forum.service.IFollower_fanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/follower_fan")
public class Follower_fanController {
    @Autowired
    private IFollower_fanService follower_fanService;

    @RequestMapping("/findall.do")
    public ModelAndView findall() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Follower_fan> follower_fans = follower_fanService.findAll();
        mv.addObject("follower_fans",follower_fans);
        mv.setViewName("follower_fan-list");
        return mv;
    }


    @RequestMapping("/savefollower_fan.do")
    public String addfollower_fan(Follower_fan follower_fan) throws Exception {
        follower_fanService.addfollower_fan(follower_fan);
        return "redirect:findall.do";
    }

    @RequestMapping("/delfollower_fan.do")
    public String delfollower_fan(Integer id) throws Exception {
        follower_fanService.delfollower_fan(id);
        return "redirect:findall.do";
    }


    @RequestMapping("/updatefollower_fan.do")
    public String updateuser(Follower_fan follower_fan) throws Exception {
        follower_fanService.updatefollower_fan(follower_fan);
        return "redirect:findall.do";
    }

    @RequestMapping("/follower_faninfo.do")
    public ModelAndView userinfo(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Follower_fan follower_fan = follower_fanService.findById(id);
        mv.addObject("follower_fan",follower_fan);
        mv.setViewName("follower_fan-show");
        return mv;
    }

}
