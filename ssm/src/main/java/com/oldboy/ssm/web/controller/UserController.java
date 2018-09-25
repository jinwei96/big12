package com.oldboy.ssm.web.controller;

import com.oldboy.ssm.domain.User;
import com.oldboy.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService us;
    /**
     * 查看用户列表
     * @return
     */
    @RequestMapping("/findlist")
    public String findList(Model m){
        List<User> list = us.findAll();
        m.addAttribute("users",list);
        return "user/userList";
    }
    @RequestMapping("/delete")
    public String delete(Integer uid){
        us.delete(uid);
        //请求转发
        return "forward:/user/findlist";
    }

    @RequestMapping("/toadd")
    public String toadd(Integer uid){

        return "user/userAdd";
    }

    @RequestMapping("/doadd")
    public String doadd(User user){
        us.insertUser(user);
        return "redirect:/user/findlist";
    }

    @RequestMapping("/edit")
    public String edit(Model m ,Integer uid){
        User u = us.findById(uid);
        m.addAttribute("user",u);
        return "/user/userEdit";
    }

    @RequestMapping("/update")
    public String update(User user){
        us.update(user);
        return "redirect:/user/findlist";
    }

}
