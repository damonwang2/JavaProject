package pdd;

/**
 * Created by pojun on 2019/1/23.
 */
public class ConnectionMeta {
    public String url;
    public String user;
    public String password;

    public ConnectionMeta(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConnectionMeta{" +
                "url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
