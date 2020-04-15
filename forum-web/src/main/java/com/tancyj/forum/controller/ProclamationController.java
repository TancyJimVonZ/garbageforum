package com.tancyj.forum.controller;

import com.tancyj.forum.domain.Proclamation;
import com.tancyj.forum.service.IProclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/proclamation")
public class ProclamationController {
    @Autowired
    private IProclamationService proclamationService;

    @RequestMapping("/findall.do")
    public ModelAndView findall() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Proclamation> proclamations = proclamationService.findAll();
        mv.addObject("proclamations",proclamations);
        mv.setViewName("proclamation-list");
        return mv;
    }


    @RequestMapping("/saveproclamation.do")
    public String addproclamation(Proclamation proclamation) throws Exception {
        proclamationService.addproclamation(proclamation);
        return "redirect:findall.do";
    }

    @RequestMapping("/delproclamation.do")
    public String delproclamation(Integer proid) throws Exception {
        proclamationService.delproclamation(proid);
        return "redirect:findall.do";
    }


    @RequestMapping("/updateproclamation.do")
    public String updateuser(Proclamation proclamation) throws Exception {
        proclamationService.updateproclamation(proclamation);
        return "redirect:findall.do";
    }

    @RequestMapping("/proclamationinfo.do")
    public ModelAndView userinfo(Integer proid) throws Exception {
        ModelAndView mv = new ModelAndView();
        Proclamation proclamation = proclamationService.findById(proid);
        mv.addObject("proclamation",proclamation);
        mv.setViewName("proclamation-show");
        return mv;
    }
}
