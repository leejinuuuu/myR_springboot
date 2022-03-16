package com.test.test.tables;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public String user_id;
    public String user_password;
    public String user_nickname;
    public String user_email;

    public ArrayList<DownloadDTO> download;
    public ArrayList<CommentDTO> comment;
}