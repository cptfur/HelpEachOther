package domain;
public class message {
    private int id;
    private String phonenumber;
    private String address;
    private String thing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "message{" +
                "id=" + id +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                ", thing='" + thing + '\'' +
                '}';
    }
}
