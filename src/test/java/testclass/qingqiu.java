package testclass;

import com.alibaba.fastjson.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.loginMain;
import org.junit.Test;
import uitis.UrlTools;

import java.util.HashMap;
import java.util.Map;

import static main.loginMain.strCookie;

public class qingqiu  {

    @Test
    public void  ceshi() {
        Map<String, Object> data=new HashMap<String, Object>();

//        data.put("username", "zxz");
//        data.put("password", "123456");
//        data.put("type", "0");
        Response response = RestAssured.given()
                .contentType("application/json")
                .auth().preemptive().oauth2("6d17aff8229e4376bb9ed7f3ebee2f6b")
//                .formParams(data)
                .body(data)
                .when().get("http://test-szxy.bjjh.org.cn/platform/platform/sys-level/handle");
        String response1 =  response.getBody().asString();
        System.out.println(response1);
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        //获取返回值ciphertext字段内容（密文）

    }


}
