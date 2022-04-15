package com.haining820.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Com {
    private int comId;
    private int comAccountNum;
    private String comPwd;
    private String comUserName;
    private String comName;
    private String comIntro;
    private String comAddress;
    private String comEmail;
    private String comTel;
    private String comWeb;
    private String comCreateTime;
}
