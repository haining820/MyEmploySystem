import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {
    @Test
    public void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        String format = sdf.format(date);
        System.out.println(format);
    }

    @Test
    public void test2(){
    }
}
