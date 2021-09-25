package test;

import dao.impl.UserDaoImpl;
import dao.impl.covid19;
import domain.COVID19;
import domain.User;
import domain.checkbox;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void test1(){
        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.findByphonenumber("2314");
        System.out.println(user);
    }
    @Test
    public void test2(){
        UserDaoImpl dao = new UserDaoImpl();
        User login = dao.login("18344125781","123456789");
        System.out.println(login);
    }
    @Test
    public void test3(){
        User user = new User();
        user.setPhonenumber("18344125781");
        user.setPassword("123456789");
        UserServiceImpl userService = new UserServiceImpl();
        User loginUser=userService.login(user);
        System.out.println(loginUser);
    }
    @Test
    public void test4(){
        checkbox checkbox=new checkbox();
        String text = checkbox.getCheckCode();
        System.out.println(text);
    }
    @Test
    public void test5(){
        List<COVID19> covid19List;
        covid19List = new ArrayList<COVID19>();
        String url="https://voice.baidu.com/act/newpneumonia/newpneumonia/?from=osari_aladin_banner&city=%E9%87%8D%E5%BA%86-%E9%87%8D%E5%BA%86";
        try {
            COVID19 covid19=new COVID19();
            Document document = Jsoup.parse(new URL(url), 30000);

            Elements elements = document.getElementsByTag("body");
            Elements elementsByClass = document.getElementsByClass("Virus_1-1-315_3U87rg");
            for (Element s:elementsByClass
                 ) {
                System.out.println(s.html());
            }
            //<div class="Virus_1-1-315_3U87rg">重庆</div>
            //<div class="ProvinceSummary_1-1-315_3Zia33"><div class="ProvinceSummary_1-1-315_2Ht3nh"><div class="ProvinceSummary_1-1-315_Tdrvui"><p class="ProvinceSummary_1-1-315_3rMEXh">新增确诊</p><p class="ProvinceSummary_1-1-315_1RW2uk ProvinceSummary_1-1-315_3VPD1o ProvinceSummary_1-1-315_pBq9kt">0</p></div><div class="ProvinceSummary_1-1-315_Tdrvui"><p class="ProvinceSummary_1-1-315_3rMEXh">新增本土</p><p class="ProvinceSummary_1-1-315_1RW2uk ProvinceSummary_1-1-315_3aIcdg ProvinceSummary_1-1-315_pBq9kt">0</p></div><div class="ProvinceSummary_1-1-315_Tdrvui"><p class="ProvinceSummary_1-1-315_3rMEXh">新增境外</p><p class="ProvinceSummary_1-1-315_1RW2uk ProvinceSummary_1-1-315_28XUOa ProvinceSummary_1-1-315_pBq9kt">0</p></div><div class="ProvinceSummary_1-1-315_Tdrvui"><p class="ProvinceSummary_1-1-315_3rMEXh">新增无症状</p><p class="ProvinceSummary_1-1-315_1RW2uk ProvinceSummary_1-1-315_19j0la ProvinceSummary_1-1-315_pBq9kt">0</p></div></div><div class="ProvinceSummary_1-1-315_2Ht3nh"><div class="ProvinceSummary_1-1-315_Tdrvui"><p class="ProvinceSummary_1-1-315_3rMEXh">现有确诊</p><p class="ProvinceSummary_1-1-315_F8LjRz ProvinceSummary_1-1-315_1RW2uk ProvinceSummary_1-1-315_pBq9kt">1</p></div><div class="ProvinceSummary_1-1-315_Tdrvui"><p class="ProvinceSummary_1-1-315_3rMEXh">累计确诊</p><p class="ProvinceSummary_1-1-315_1D9-m- ProvinceSummary_1-1-315_1RW2uk ProvinceSummary_1-1-315_pBq9kt">603</p></div><div class="ProvinceSummary_1-1-315_Tdrvui"><p class="ProvinceSummary_1-1-315_3rMEXh">累计治愈</p><p class="ProvinceSummary_1-1-315_1U_RUn ProvinceSummary_1-1-315_1RW2uk ProvinceSummary_1-1-315_pBq9kt">596</p></div><div class="ProvinceSummary_1-1-315_Tdrvui"><p class="ProvinceSummary_1-1-315_3rMEXh">累计死亡</p><p class="ProvinceSummary_1-1-315_2_KQ82 ProvinceSummary_1-1-315_1RW2uk ProvinceSummary_1-1-315_pBq9kt">6</p></div></div></div>
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test6(){
        String url="https://ncov.dxy.cn/ncovh5/view/pneumonia" ;
        try {
            Document document = Jsoup.connect(url).get();
            System.out.println(document);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test8(){
        covid19 covid19 =new covid19();
        try {
            covid19.getAreaStat();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
