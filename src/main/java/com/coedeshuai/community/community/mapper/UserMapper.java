package com.coedeshuai.community.community.mapper;

import com.coedeshuai.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/6/14 17:25
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER (name,account_id,token,gmt_create,gmt_modified) VAlUES (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

}
