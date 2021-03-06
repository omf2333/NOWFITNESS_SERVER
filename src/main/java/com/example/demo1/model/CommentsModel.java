package com.example.demo1.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CommentsModel {
    private int id;
    private int momentsId;
    private String content;
    private int commentUserId ;
    private Date commentTime;

    private String commentUserPhoto;
    private String commentUserName;
    private String commentUserNickName;

    private List<RepliesModel> repliesList;
}
