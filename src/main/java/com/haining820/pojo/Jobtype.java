package com.haining820.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jobtype {
    private int jobtypeId;
    private String jobtypeName;
    private String jobtypeCreateTime;
}
