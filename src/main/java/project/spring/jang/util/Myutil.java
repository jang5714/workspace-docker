package project.spring.jang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Myutil {
    public String now(){
        return new SimpleDateFormat("yyyy-MM-dd aa hh:mm:ss").format(new Date());
    }
}
