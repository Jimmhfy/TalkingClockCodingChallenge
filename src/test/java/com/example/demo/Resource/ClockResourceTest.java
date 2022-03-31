package com.example.demo.Resource;

import com.example.demo.Model.Clock;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
class ClockResourceTest {
    @Test
    public void validValueRequest(){
        ClockResource clockResource = new ClockResource();
        String request = "15:30";
        var actual = clockResource.getTime(request);

        JSONObject actualResponseJSONObject = new JSONObject(actual);
        JSONObject expectedResponseJSONObject = new JSONObject();
        expectedResponseJSONObject.put("response", "Half past three");
        JSONAssert.assertEquals(actualResponseJSONObject, expectedResponseJSONObject, true);
    }

    @Test
    public void invalidValueRequest(){
        ClockResource clockResource = new ClockResource();
        String request = "2530";
        var actual = clockResource.getTime(request);

        JSONObject actualResponseJSONObject = new JSONObject(actual);
        JSONObject expectedResponseJSONObject = new JSONObject();
        expectedResponseJSONObject.put("errorMessage", "Invalid input");
        JSONAssert.assertEquals(actualResponseJSONObject, expectedResponseJSONObject, false);
    }
}