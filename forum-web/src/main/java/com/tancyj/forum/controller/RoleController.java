package com.tancyj.forum.controller;

import com.tancyj.forum.domain.Role;
import com.tancyj.forum.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findall.do")
    public ModelAndView findall() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roles",roles);
        mv.setViewName("role-list");
        return mv;
    }


    @RequestMapping("/saverole.do")
    public String addrole(Role role) throws Exception {
        roleService.addrole(role);
        return "redirect:findall.do";
    }

    @RequestMapping("/delrole.do")
    public String delrole(Integer roleid) throws Exception {
        roleService.delrole(roleid);
        return "redirect:findall.do";
    }


    @RequestMapping("/updaterole.do")
    public String updateuser(Role role) throws Exception {
        roleService.updaterole(role);
        return "redirect:findall.do";
    }

    @RequestMapping("/roleinfo.do")
    public ModelAndView userinfo(Integer roleid) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleid);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
}
