package uitis;

public class UrlTools {

    //网校正式环境
    public  static final String Whost= "http://jhwx.bjjh.org.cn/sys";
    //网校测试环境
    public  static final String WThost= "";
    //统一平台正式环境
    public  static final String Tongyihost= "http://szxy.bjjh.org.cn";
    //统一平台测试环境
    public  static final String TongTesthost= "http://test-szxy.bjjh.org.cn";

    //网校接口
    public static final String cateGoryList = Whost+"/xjzdApi/course/cateGoryList";
    public static final String videoList = Whost+"/xjzdApi/video/list";
    public static final String videoXiang = Whost+"/xjzdApi/video/selectVideo";
    public static final String videoTui = Whost+"/xjzdApi/video/recommend";
    public static final String LoginOut = Whost+"/xjzdApi/login/out";
    //统一平台接口
    public static final String Tlogin = TongTesthost+"/sso/sso/login";
    public static final String userMenuTree = TongTesthost+"/platform/platform/userMenuTree";
    public static final String seleById = TongTesthost+"/system/system/seleById";

}
