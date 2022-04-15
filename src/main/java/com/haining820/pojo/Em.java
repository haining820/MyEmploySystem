package com.haining820.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Em {
    private int emId;
    private int emAccountNum;
    private String emPwd;
    private String emUsername;
    private String emName;
    private String emSex;
    private String emBirth;
    private String emSchool;
    private String emIntro;
    private String emEmail;
    private String emTel;
    private String emGraduateTime;
    private String emCreateTime;
    private String emFile;
}
