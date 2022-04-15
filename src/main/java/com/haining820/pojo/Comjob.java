package com.haining820.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comjob {
    private int comjobId;
    private String jobId;
    private String comId;
    private String comjobIntro;
    private String salary;
    private String workTime;
    private String workAddress;
    private int hireMaxNum;
    private int hiredNum;
    private String comjobCreateTime;
}
