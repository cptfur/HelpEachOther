package domain;

public class information {
    private int id;
    private String username;
    private String phonenumber;
    private String address;
    private String thing;
    private String number;
    private String rnumber;
    private String lat;
    private String lng;

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

    public String getRnumber() {
        return rnumber;
    }

    public void setRnumber(String rnumber) {
        this.rnumber = rnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "information{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                ", thing='" + thing + '\'' +
                ", number='" + number + '\'' +
                ", rnumber='" + rnumber + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
