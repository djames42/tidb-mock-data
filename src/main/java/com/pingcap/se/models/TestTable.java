package com.pingcap.se.models;

import org.json.JSONObject;

public class TestTable {
    private int field1;
    private int field2;
    private String field3;
    private float field4;
    private float field5;
    private JSONObject field6;

    public TestTable(int field1, int field2, String field3, float field4, float field5, JSONObject field6) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
    }

    public int getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public float getField4() {
        return field4;
    }

    public float getField5() {
        return field5;
    }

    public JSONObject getField6() {
        return field6;
    }
}