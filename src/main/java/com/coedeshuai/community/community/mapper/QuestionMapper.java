package com.coedeshuai.community.community.mapper;

import com.coedeshuai.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/6/14 23:49
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
