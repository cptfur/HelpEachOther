package domain;

public class weather {
    private String weather;
    private String  temperature;
    private String  wind;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "weather{" +
                "weather='" + weather + '\'' +
                ", temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                '}';
    }
}
