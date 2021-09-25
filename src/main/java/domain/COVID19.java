package domain;

public class COVID19 {
//    cityName,currentConfirmedCount,confirmedCount,curedCount,deadCount,suspectedCount
    private String provinceName;
    private String cityName;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String curedCount;
    private String deadCount;
    private String suspectedCount;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(String currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public String getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(String confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public String getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(String curedCount) {
        this.curedCount = curedCount;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    public String getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(String suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    @Override
    public String toString() {
        return "COVID19{" +
                "cityName='" + cityName + '\'' +
                ", currentConfirmedCount='" + currentConfirmedCount + '\'' +
                ", confirmedCount='" + confirmedCount + '\'' +
                ", curedCount='" + curedCount + '\'' +
                ", deadCount='" + deadCount + '\'' +
                ", suspectedCount='" + suspectedCount + '\'' +
                '}';
    }
}
