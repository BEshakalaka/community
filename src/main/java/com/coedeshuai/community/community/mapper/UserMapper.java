package com.coedeshuai.community.community.mapper;

import com.coedeshuai.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/6/14 17:25
 */
@Mapper
public interface UserMapper {

//   注册用户信息到数据库
    @Insert("INSERT INTO USER (name,account_id,token,gmt_create,gmt_modified,avatar_url) VAlUES (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);
//  根据token查询是否存在该用户
    @Select("select * from USER where token = #{token} limit 1")
    User findByToken(@Param("token") String token);
}
