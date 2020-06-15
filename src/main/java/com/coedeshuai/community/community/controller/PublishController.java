package com.coedeshuai.community.community.controller;

import com.coedeshuai.community.community.mapper.QuestionMapper;
import com.coedeshuai.community.community.mapper.UserMapper;
import com.coedeshuai.community.community.model.Question;
import com.coedeshuai.community.community.model.User;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/6/14 23:03
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title")String title,
            @RequestParam("description")String description,
            @RequestParam("tag")String tag,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if(StringUtils.isNullOrEmpty(title)){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if(StringUtils.isNullOrEmpty(description)){
            model.addAttribute("error","问题不能为空");
            return "publish";
        }
        if(StringUtils.isNullOrEmpty(tag)){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        User user = null;
//      先判断cookies为空，则直接放index.html
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length!=0)
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
//      创建question对象，并赋值
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";
    }
}
