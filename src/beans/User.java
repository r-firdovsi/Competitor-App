package beans;

public class User {
    private String usermane;
    private String password;
    private int point;

    public User() {
    }

    public User(String usermane, String password) {
        this.usermane = usermane;
        this.password = password;

    }

    public String getUsermane() {
        return usermane;
    }

    public void setUsermane(String usermane) {
        this.usermane = usermane;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
