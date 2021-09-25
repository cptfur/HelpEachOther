package domain;

public class location {
    /*"module": "geolocation",
                "type": "ip",
                "adcode": 500235,
                "nation": "中国",
                "province": "重庆市",
                "city": "重庆市",
                "addr": "",
                "lat": 30.93063,
                "lng": 108.69698,
                "accuracy": 10000*/
    private String nation;
    private String province;
    private String city;
    private String addr;
    private String lat;
    private String lng;
    private String accuracy;
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "location{" +
                "nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", addr='" + addr + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", accuracy='" + accuracy + '\'' +
                '}';
    }
}
