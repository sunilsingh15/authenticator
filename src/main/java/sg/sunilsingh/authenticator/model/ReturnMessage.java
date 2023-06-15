package sg.sunilsingh.authenticator.model;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class ReturnMessage {

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
        .add("message", this.getMessage())
        .build();
    }

}
