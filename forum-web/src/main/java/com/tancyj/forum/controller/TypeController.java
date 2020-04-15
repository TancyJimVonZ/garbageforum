package com.tancyj.forum.controller;

import com.tancyj.forum.domain.Type;
import com.tancyj.forum.domain.User;
import com.tancyj.forum.service.ITypeService;
import com.tancyj.forum.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private ITypeService typeService;


    @RequestMapping("/findall.do")
    public ModelAndView findall() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Type> types = typeService.findAll();
        mv.addObject("types",types);

        mv.setViewName("type-list");
        return mv;
    }


    @RequestMapping("/savetype.do")
    public String addtype(Type type) throws Exception {
//        System.out.println(user);
        typeService.addtype(type);
        return "redirect:findall.do";
    }

    @RequestMapping("/deltype.do")
    public String deltype(Integer type_id) throws Exception {
        typeService.deltype(type_id);
        return "redirect:findall.do";
    }


    @RequestMapping("/updatetype.do")
    public String updateuser(Type type) throws Exception {
        typeService.updatetype(type);
        return "redirect:findall.do";
    }

    @RequestMapping("/typeinfo.do")
    public ModelAndView userinfo(Integer type_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Type type = typeService.findById(type_id);
        mv.addObject("type",type);
        mv.setViewName("type-show");
        return mv;
    }


}
