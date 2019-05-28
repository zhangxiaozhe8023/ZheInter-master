package main;

import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class mainTest{

    private String Keywor22;
    private String response1;

    private JSONObject jsonQuan;
    private JSONObject jsonItem;
    private String resultcode;
    private String resultinfo = "";

    //调用主的接口方法
    @Test
    public void InterTestJson( Map<String, Object> Mapdata, String PostUrl, String ReCode){
        //发送post请求
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(Mapdata)
                .when().post(PostUrl);
        //获得body信息
         response1 =  response.getBody().asString();
        if(response1==null){
            throw new RuntimeException("发送请求不正确");
        }else{

        }
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        System.out.println(obj.toString());
            //把String转为json对象
            jsonQuan = JSONObject.parseObject(response1);
            //得到item的json对象
            jsonItem = jsonQuan.getJSONObject("data");
            String itemStr = jsonItem.toString();
            System.out.println(jsonItem.toString());
            //得到reslut返回值
        if(itemStr.equals("{}")){
            System.out.println("登录态失效");
        }else{
            //获得相应字段
            resultcode =  jsonItem.getString("ReCode");
            System.out.println(resultcode);
        }



//            //判断result返回值
//            if(resultcode .equals(ReCode)== true){
//                //判断result返回值
//                Assert.assertEquals("返回码是否是相等",ReCode,resultcode);
//                System.out.println("用例通过");
//            } else {
//                //判断result返回值
//                Assert.assertEquals("返回码是否是相等-->"+resultinfo,ReCode,resultcode);
//
//            }
    }
    public void InterTestForm(Map<String, Object> Mapdata, String PostUrl, String ReCode){
        //发送post请求
        Response response = RestAssured.given()
                .body(Mapdata)
                .when().post(PostUrl);
        //获得body信息
        response1 =  response.getBody().asString();
        if(response1==null){
            throw new RuntimeException("发送请求不正确");
        }else{

        }
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        System.out.println(obj.toString());

            //把String转为json对象
            jsonQuan = JSONObject.parseObject(response1);
            //得到item的json对象
            jsonItem = jsonQuan.getJSONObject("data");
            System.out.println(jsonItem.toString());
            //得到reslut返回值
            resultcode =  jsonItem.getString("username");
            System.out.println(resultcode);

//            //判断result返回值
//            if(resultcode .equals(ReCode)== true){
//                //判断result返回值
//                Assert.assertEquals("返回码是否是相等",ReCode,resultcode);
//                System.out.println("用例通过");
//            } else {
//                //判断result返回值
//                Assert.assertEquals("返回码是否是相等-->"+resultinfo,ReCode,resultcode);
//
//            }

    }
    //参数1：接口传入参数  参数2：传入URL 参数3：请求方式 参数4：返回结果
    public void sendPost( Map<String, Object> Mapdata, String PostUrl, String ResponType, String ReCode){

        //发送post请求
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(Mapdata)
                .when().post(PostUrl);
        //获得body信息
        String response1 =  response.getBody().asString();
        if(response1==null){
            throw new RuntimeException("发送请求不正确");
        }else{

        }
        //获得JSONObject对象并打印
        JSONObject obj = JSONObject.parseObject(response1);
        System.out.println(obj.toString());
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");

    }
    //参数1：接口传入参数  参数2：传入URL 参数3：请求方式 参数4：返回结果
    @Test
    public void sendPost2(){

        Map<String, String> Mapcookie = new HashMap<String, String>();
        //发送post请求
//        Response response = RestAssured.given()
////                .contentType("application/json")
//                .formParams("username","18310614641","password","123456a")
//                .when().post("http://support.ezhixin.com/a/userLogin");
        Response response = RestAssured.given()
//                .contentType("application/json")
                .formParams("account","15168381330","password","123456")
                .when().post("https://wsc.wlo.wxfenxiao.com/wlapi/user/loginIndex");
        //获得body信息
        String response1 =  response.getBody().asString();
        Mapcookie = response.getCookies();
        System.out.println(Mapcookie);
        if(response1==null){
            throw new RuntimeException("发送请求不正确");
        }else{
            System.out.println(response1);
        }

    }

    public void sendPost3(Map<String, Object> Mapdata, String PostUrl, String loginCookie, String resultKeyword) {
        Keywor22 = resultKeyword;
        System.out.println(Keywor22);
        ResponseBody response = RestAssured.given().cookie("JSESSIONID", loginCookie)
                .contentType("application/json")
                .body(Mapdata)
                .when().post(PostUrl);

        //获得body信息
        response1 = response.asString();
        if(response1==null){
            throw new RuntimeException("发送请求不正确");
        }else{
            System.out.println(response1);
        }

    //判断result返回值，是否包含关键字
        Assert.assertThat(response1, isLinkinStr());
    }

    public Matcher<String> isLinkinStr() {
        return new BaseMatcher<String>()
        {
            public boolean matches(Object item)
            {
                if (!(item instanceof String))
                {
                    return false;
                }
                return ((String) item).contains(Keywor22);
            }

            public void describeTo(Description description)
            {
                description.appendText("字符串必须包含"+Keywor22+"这个单词。。。");
            }

        };
    }

}
