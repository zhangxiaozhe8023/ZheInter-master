package wangmain;

import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;

import java.util.HashMap;

import static uitis.UrlTools.Whost;

public class wangLoginMain {
    public static String strCookie  = "";

    @BeforeClass
    public static void Fistclass() throws InterruptedException {

//        List<String> values = new ArrayList<String>();
        HashMap<String,Object> values= new HashMap<String, Object>();
        values.put("username","zxz");
        values.put("password","123456");

        //发送post请求
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(values)
                .when().post(Whost+"/xjzdApi/auth");
        //获得body信息
        String response1 =  response.getBody().asString();
        JSONObject jsonObject = JSONObject.parseObject(response1);
        JSONObject jsonObject1 = jsonObject.getJSONObject("data");

        strCookie = jsonObject1.getString("token");
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
