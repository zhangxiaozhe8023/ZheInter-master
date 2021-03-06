package main;

import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static uitis.UrlTools.Tlogin;

public class loginMain {
    public static String strCookie  = "";
    @BeforeClass
    public static void Fistclass() throws InterruptedException {
        HashMap<String,Object> values= new HashMap<String, Object>();
        values.put("username","dianjiao3");
        values.put("password","123456");
        values.put("type","0");
        //发送post请求
        Response response = RestAssured.given()
                .formParams(values)
                .when().post(Tlogin);
        //获得body信息
        String response1 =  response.getBody().asString();
        JSONObject jsonObject = JSONObject.parseObject(response1);
        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
// 获取所有 headers 信息
        // 获取所有 cookie 键值对

        strCookie = jsonObject1.getString("token");
        //判断token是否为空
        String ifToken = strCookie;
        if(ifToken==null){
            throw new RuntimeException("token值为空");
        }else{
            System.out.println(strCookie);
        }
        if(response1==null){
            throw new RuntimeException("发送请求不正确");
        }else{
            System.out.println(response1);
        }
    }
}
