package com.haining820.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private int jobId;
    private String jobtypeId;  // 在创建实体类时用 jobtypeName 代替 jobtypeId
    private String jobName;
    private String jobCreateTime;
}
