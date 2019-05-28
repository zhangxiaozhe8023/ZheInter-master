package main;

import org.junit.Test;
import uitis.UrlTools;
import java.util.HashMap;

public class initTest  extends loginMain {
    public static HashMap<String,Object> dataMap= new HashMap<String, Object>();
    mainTest main = new mainTest();

    //待办事项
    @Test
    public void Login(){
        dataMap.put("id","1133177251376263174");
        dataMap.put("Authorization",strCookie);
        main.InterTestJson(dataMap,"http://test-schodesk.bjjh.org.cn:9000/platform/platform/sys-level/pastTimes","d");

        System.out.println(strCookie);
    }
    //查看个人信息
    @Test
    public void gerenLogin(){
        dataMap.put("Authorization",strCookie);
        main.InterTestForm(dataMap,"http://test-schodesk.bjjh.org.cn:9000/platform/system/seleById","d");

    }

}
