package com.haining820.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analysis {
    int comjobId;
    int hireMaxNum;
    int hiredNum;
    double rate;
}
