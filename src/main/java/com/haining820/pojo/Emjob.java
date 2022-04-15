package com.haining820.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Emjob {
    private int emjobId;
    private String comjobId;
    private String emId;
    private String reply;
    private String res;
    private String emjobCreateTime;

    public Emjob(String comjobId, String emId, String reply, String res, String emjobCreateTime) {
        this.comjobId = comjobId;
        this.emId = emId;
        this.reply = reply;
        this.res = res;
        this.emjobCreateTime = emjobCreateTime;
    }
}
