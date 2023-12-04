package com.pingcap.se.models;

import com.pingcap.se.services.Randomise;
import org.json.JSONObject;
import org.json.JSONStringer;

public class JsonExtensions {
    private int age;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String username;
    private String password;
    private float rank;

    public JSONObject toJSON() {
        JSONStringer jsonStringer = new JSONStringer();

        jsonStringer.object();
        jsonStringer.key("age").value(this.age);
        jsonStringer.key("first_name").value(this.firstName);
        jsonStringer.key("last_name").value(this.lastName);
        jsonStringer.key("address").value(this.address);
        jsonStringer.key("postal_code").value(this.postalCode);
        jsonStringer.key("username").value(this.username);
        jsonStringer.key("password").value(this.password);
        jsonStringer.key("rank").value(this.rank);
        jsonStringer.endObject();

        JSONObject jsonObject = new JSONObject(jsonStringer.toString());
        return jsonObject;
    }

    public JsonExtensions() {
        Randomise randomise = new Randomise();
        this.age = randomise.randomInt(110);
        this.firstName = randomise.randomString(15);
        this.lastName = randomise.randomString(15);
        this.address = String.format("%3d %s %s %s", randomise.randomInt(99999),randomise.randomString(4), randomise.randomString(20), randomise.randomString(3));
        this.postalCode = String.format("%05d", randomise.randomInt(99999));
        this.rank = randomise.randomFloat();
        this.username = randomise.randomString(8);
        this.password = randomise.randomString(32);
    }
}
