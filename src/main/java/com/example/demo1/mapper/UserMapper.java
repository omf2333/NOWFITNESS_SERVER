package com.example.demo1.mapper;

import com.example.demo1.model.UserModel;
import org.apache.ibatis.annotations.*;

 /**
  * @Description:  数据库中user表对应的操作接口
  */
@Mapper
public interface UserMapper {

    @Insert({"INSERT INTO `nowfitness`.`user` (userName,password,height,weight,sex,age,picture,nickName,states,salt,token) " +
            "value(#{userName},#{password},#{height},#{weight},#{sex},#{age},#{picture},#{nickName},#{states},#{salt},#{token})"})
    void register( UserModel userModel);

    @Select("SELECT * FROM `nowfitness`.`user` where userName = #{userName} ")
    UserModel findUserByName(String userName);

    @Update("UPDATE `nowfitness`.`user` SET `token` = #{token} WHERE `id` = #{id};")
    int updateUserToken(@Param("id") int id,@Param("token") String token);


    @Select("SELECT * FROM `nowfitness`.`user` where id = #{id} ")
    UserModel findById(int id);

    @Select("SELECT id FROM `nowfitness`.`user` where userName = #{userName} ")
    int findUserId(String userName);

    @Update("UPDATE `nowfitness`.`user` SET `password` = #{password},`salt` = #{salt} WHERE `id` = #{id};")
    int updateUserPassword(@Param("id") int id ,@Param("password") String password,@Param("salt")String salt);

    @Update("UPDATE `nowfitness`.`user` SET `height` = #{height},`weight` = #{weight},`sex` = #{sex},`age` = #{age},`picture` = #{picture},`nickName`=#{nickName} WHERE `id` = #{id};")
    int updateUserData(UserModel userModel);

    @Update("UPDATE `nowfitness`.`user` SET `picture` = #{picture} WHERE `id` = #{id};")
    int updateUserPhoto(@Param("id") int id,@Param("picture") String picture);



}
