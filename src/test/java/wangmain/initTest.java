package wangmain;

import main.mainTest;
import org.junit.Test;

import java.util.HashMap;

import static uitis.UrlTools.*;

public class initTest extends wangLoginMain {
    public  HashMap<String, Object> dataMap = new HashMap<String, Object>();
    WangMainTest main = new WangMainTest();

    //查询学科
    @Test
    public void cateGoryList() {

        main.InterTestJson(dataMap, cateGoryList, "语文");

    }
    @Test
    public void videolist() {
        dataMap.put("pageNum", "1");
        dataMap.put("pageSize", "15");
        main.InterTestJson(dataMap, videoList, "高三");
    }
    @Test
    public void videoXiang() {
        dataMap.put("videoId", "169400");
        main.InterTestJson(dataMap, videoXiang, "张老师");
    }
    //视频推荐（有问题）
    @Test
    public void videoTui() {
        dataMap.put("classId", "169400");
        main.InterTestJson(dataMap, videoTui, "张老师");
    }
    //退出
    @Test
    public void LoginOut() {
        dataMap.put("token", strCookie);
        main.InterTestJson(dataMap, LoginOut, "请求成功");
    }

}
