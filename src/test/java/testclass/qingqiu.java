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
//                .auth().oauth2("28f7cd967b87479e8bf568e6b3302140")
                .header("Authorization","28f7cd967b87479e8bf568e6b3302140")

//                .formParams(data)
//                .body(data)
                .when().get("http://test-szxy.bjjh.org.cn/platform/platform/userMenuTree");
        String response1 =  response.getBody().asString();
        System.out.println(response1);

    }


}
