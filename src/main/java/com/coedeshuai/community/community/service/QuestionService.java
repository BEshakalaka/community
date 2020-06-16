package com.coedeshuai.community.community.service;

import com.coedeshuai.community.community.dto.QuestionDTO;
import com.coedeshuai.community.community.mapper.QuestionMapper;
import com.coedeshuai.community.community.mapper.UserMapper;
import com.coedeshuai.community.community.model.Question;
import com.coedeshuai.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/6/16 23:12
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//          快速的将question的属性拷贝到questionDTO上（有点坑）
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
