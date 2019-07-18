package wangmain;

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

import static wangmain.wangLoginMain.strCookie;


public class WangMainTest {

    private String Keywor22;
    private String response1;
    private JSONObject jsonQuan;
    private JSONObject jsonItem;
    private String resultcode;
    private String resultinfo = "";
    private String itemStr = "";

    //调用主的接口方法Type为application/json
    @Test
    public void InterTestJson( Map<String, Object> Mapdata, String PostUrl, String ReCode){
        System.out.println(strCookie);
        //发送post请求
        Response response = RestAssured.given()
                .auth().oauth2(strCookie)
                .contentType("application/json")
                .body(Mapdata)
                .cookie("status","logined")
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
            String gg =jsonQuan.toString();
            //得到item的json对象
//            jsonItem = jsonQuan.getJSONObject("data");
//             itemStr = jsonItem.toString();
//        System.out.println(jsonItem.toString());
//        JSONArray jsonItem2 = jsonItem.getJSONArray("kemu");
//        System.out.println(jsonItem2.toString());

            //得到reslut返回值
        if(itemStr.equals("{}")){
            System.out.println("登录态失效");
        }else{
            //判断result返回值，是否包含关键字
            Assert.assertThat(gg, isLinkinStr2(ReCode));
            System.out.println("测试通过- ->包含"+ReCode);
        }
    }
    public Matcher<String> isLinkinStr2(final String dd) {
        return new BaseMatcher<String>()
        {
            public boolean matches(Object item)
            {
                if (!(item instanceof String))
                {
                    return false;
                }
                return ((String) item).contains(dd);
            }

            public void describeTo(Description description)
            {
                description.appendText("字符串必须包含"+dd+"这个单词。。。");
            }

        };
    }

    //调用主的接口方法Type为form
    @Test
    public void InterForm( Map<String, Object> Mapdata, String PostUrl, String ReCode){
        System.out.println(strCookie);
        //发送post请求
        Response response = RestAssured.given()
                .auth().oauth2(strCookie)
                .contentType("application/x-www-form-urlencoded")
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
        String gg =jsonQuan.toString();
        //得到reslut返回值
        if(itemStr.equals("{}")){
            System.out.println("登录态失效");
        }else{
            //判断result返回值，是否包含关键字
            Assert.assertThat(gg, isLinkinStr3(ReCode));
            System.out.println("测试通过- ->包含"+ReCode);
        }
    }
    public Matcher<String> isLinkinStr3(final String dd) {
        return new BaseMatcher<String>()
        {
            public boolean matches(Object item)
            {
                if (!(item instanceof String))
                {
                    return false;
                }
                return ((String) item).contains(dd);
            }

            public void describeTo(Description description)
            {
                description.appendText("字符串必须包含"+dd+"这个单词。。。");
            }

        };
    }


    public void InterTestForm(Map<String, Object> Mapdata, String PostUrl, String KeyStr ,String valeStr){
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
            //得到内层的json对象
            jsonItem = jsonQuan.getJSONObject("data");
            System.out.println(jsonItem.toString());
            //得到传过来的某个字段返回值
            resultcode =  jsonItem.getString(KeyStr);
            System.out.println(resultcode);

            //判断result返回值
            if(resultcode .equals(valeStr)== true){
                //判断result返回值
                Assert.assertEquals("返回码是否是相等",valeStr,resultcode);
                System.out.println("用例通过");
            } else {
                //判断result返回值
                Assert.assertEquals("返回码是否是相等-->"+resultinfo,valeStr,resultcode);

            }

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
