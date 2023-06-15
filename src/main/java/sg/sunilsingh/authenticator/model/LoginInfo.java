package sg.sunilsingh.authenticator.model;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class LoginInfo {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static LoginInfo create(String json) {

        LoginInfo login = new LoginInfo();

        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject object = reader.readObject();

        login.setUsername(object.getString("username"));
        login.setPassword(object.getString("password"));

        return login;

    }

}
