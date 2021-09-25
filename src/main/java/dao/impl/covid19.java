package dao.impl;

import com.alibaba.fastjson.JSONArray;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class covid19 {
    public static void main(String[] args) {
        covid19 covid19=new covid19();
        try {
            covid19.getAreaStat();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void getAreaStat() throws SQLException {
        StringBuffer buffer = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        HttpsURLConnection httpsURLConnection = null;
        String htmlResult = "";
        try {
            URL url = new URL("https://ncov.dxy.cn/ncovh5/view/pneumonia");
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setRequestMethod("GET");
            inputStream = httpsURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            htmlResult=buffer.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String reg = "window.getAreaStat = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);
        String result = "";
        if (totalMatcher.find()) {
            result = totalMatcher.group(1);
            System.out.println(result);
            JSONArray array = JSONArray.parseArray(result);
            JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
            for (int i = 0; i < 30; i++) {
               com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(array.getString(i));
               String sql="update  province set provinceName=?,currentConfirmedCount=?,confirmedCount=?,curedCount=?,deadCount=?,suspectedCount=? where provinceName=?";
               template.update(sql,jsonObject.getString("provinceName"),jsonObject.getString("currentConfirmedCount"),jsonObject.getString("confirmedCount"),jsonObject.getString("curedCount"),jsonObject.getString("deadCount"),jsonObject.getString("suspectedCount"),jsonObject.getString("provinceName"));
                JSONArray array2 = jsonObject.getJSONArray("cities");
                for(int j =0; j < array2.size(); j++){
                    com.alibaba.fastjson.JSONObject jsonObject2 = com.alibaba.fastjson.JSONObject.parseObject(array2.getString(j));
                    String sql1="update  province set cityName=?,currentConfirmedCount=?,confirmedCount=?,curedCount=?,deadCount=?,suspectedCount=? where cityName=?";
                    template.update(sql1,jsonObject2.getString("cityName"),jsonObject2.getString("currentConfirmedCount"),jsonObject2.getString("confirmedCount"),jsonObject2.getString("curedCount"),jsonObject2.getString("deadCount"),jsonObject2.getString("suspectedCount"),jsonObject.getString("cityName"));
                }
            }

            }

    }
}
