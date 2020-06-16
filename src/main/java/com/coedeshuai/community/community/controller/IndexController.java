package com.coedeshuai.community.community.controller;

import com.coedeshuai.community.community.dto.QuestionDTO;
import com.coedeshuai.community.community.mapper.QuestionMapper;
import com.coedeshuai.community.community.mapper.UserMapper;
import com.coedeshuai.community.community.model.Question;
import com.coedeshuai.community.community.model.User;
import com.coedeshuai.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/6/14 1:08
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){
        Cookie[] cookies = request.getCookies();
//      先判断cookies为空，则直接放index.html
        if(cookies == null){
            return "index";
        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }
}
