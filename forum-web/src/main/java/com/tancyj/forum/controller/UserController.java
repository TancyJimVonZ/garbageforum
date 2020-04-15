package com.tancyj.forum.controller;

import com.github.pagehelper.PageInfo;
import com.tancyj.forum.domain.Post;
import com.tancyj.forum.domain.User;
import com.tancyj.forum.service.IUserService;
import com.tancyj.forum.service.impl.UserServiceImpl;
import com.tancyj.forum.utils.DateUtils;
import javafx.geometry.Pos;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /*
    * 查找用户
    * 未进行分页
    * */
//    @RequestMapping("/findall1.do")
//    public ModelAndView findall1() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<User> users = userService.findAll();
//        mv.addObject("users",users);
//
//        mv.setViewName("user-list");
//        return mv;
//    }

    /***
     *
     * 分页后
     */
//    @RolesAllowed("ADMIN")
//    @RequestMapping("/findall.do")
    @RequestMapping("/findall.do")
    public ModelAndView findall(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "10")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<User> userss = userService.findAll(page,size);
        PageInfo users = new PageInfo(userss);
        mv.addObject("users",users);

        mv.setViewName("user-page-list");
        return mv;
    }




//    @RequestMapping("/adduser.do")
//    public ModelAndView adduser() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        User user = new User();
//        for (int i = 0; i < 50; i++) {
//            user.setName("test" + i);
//            user.setUsername("test" + i);
//            user.setPassword("123456");
//            user.setEmail("123@qq.com");
//            Date date = new Date();
//            user.setBirthday(date);
//            userService.adduser(user);
//        }
//
//        mv.setViewName("add");
//        return mv;
//    }
    /*@RequestMapping("/addu.do")
    public ModelAndView addu() throws Exception {
        User user = new User();
        for (int i = 0; i < 50; i++) {
            user.setName("test" + i);
            user.setUsername("test" + i);
            user.setPassword("123456");
            user.setEmail("123@qq.com");
            Date date = new Date();
            user.setBirthday(date);
            userService.adduser(user);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addus");
        return mv;
        //return "forward:addus.do";
    }*/

    /**
     * 保存用户
     * @param user
     * @return
     * @throws Exception
     */
//    @Secured("ROLE_管理员")
    @RequestMapping("/saveuser.do")
    public String adduser(User user) throws Exception {
//        System.out.println(user);
        userService.adduser(user);
        return "redirect:findall.do";
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/deluser.do")
    public String deluser(Integer uid) throws Exception {
           userService.deluser(uid);
        return "redirect:findall.do";
    }

    /**
     * 批量删除用户，使用ajax前台发送选择的uid。
     */
    /*@RequestMapping("/deleteuser.do")
    public String deleteuser(Integer[] ids) throws Exception {
           System.out.println(ids.length);
           for (Integer id : ids) {
                System.out.println(id);
                userService.deluser(id);
           }
        return "redirect:findall.do";
    }*/

    /**
     * 编辑用户
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateuser.do")
    public String updateuser(User user) throws Exception {
        System.out.println(user);
        userService.updateuser(user);
        return "redirect:findall.do";
    }

//    @PreAuthorize("authentication.principal.username=='tom'")
    @RequestMapping("/userinfo.do")
    public ModelAndView userinfo(Integer uid) throws Exception {
        ModelAndView mv = new ModelAndView();
//        System.out.println(uid);
        User user = userService.findById(uid);
        System.out.println(user);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/file.do")
//    public String fileupload1(HttpServletRequest request) throws Exception {
    public String fileupload1(HttpServletRequest request) throws Exception {
//    public String fileupload1(MultipartFile request) throws Exception {
        System.out.println("文件上传...");
//         使用fileupload组件完成文件上传
//         上传的位置
//        String path = request.getSession().getServletContext().getRealPath("/uploads/");
//        System.out.println(path);
//        // 判断，该路径是否存在
//        File file = new File(path);
//        if(!file.exists()){
//            // 创建该文件夹
//            file.mkdirs();
//        }
//
//        // 解析request对象，获取上传文件项
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        // 解析request
//        List<FileItem> items = upload.parseRequest(request);
//        // 遍历
//        for(FileItem item:items){
//            // 进行判断，当前item对象是否是上传文件项
//            if(item.isFormField()){
//                // 说明普通表单向
//            }else{
//                // 说明上传文件项
//                // 获取上传文件的名称
//                String filename = item.getName();
//                // 把文件的名称设置唯一值，uuid
//                String uuid = UUID.randomUUID().toString().replace("-", "");
//                filename = uuid+"_"+filename;
//                // 完成文件上传
//                item.write(new File(path,filename));
//                // 删除临时文件
//                item.delete();
//            }
//        }

        return "redirect:findall.do";
    }

    @RequestMapping("/fileupload2")
    public String fileuoload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传...");

        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }

        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // 完成文件上传
        upload.transferTo(new File(path,filename));

        return "success";
    }

}
