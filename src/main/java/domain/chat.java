package domain;

public class chat {
    private String send;
    private String get;
    private String message;

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "chat{" +
                "send='" + send + '\'' +
                ", get='" + get + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
