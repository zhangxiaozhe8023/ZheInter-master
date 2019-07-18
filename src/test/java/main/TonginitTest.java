package main;

import org.junit.Test;

import java.util.HashMap;

import static uitis.UrlTools.seleById;
import static uitis.UrlTools.userMenuTree;

public class TonginitTest extends loginMain{
    public HashMap<String, Object> dataMap = new HashMap<String, Object>();
    mainTest main = new mainTest();
    //获取树形菜单
    @Test
    public void userMenuTree() {
        main.InterTestJson(dataMap, userMenuTree, "请假");
    }
}
