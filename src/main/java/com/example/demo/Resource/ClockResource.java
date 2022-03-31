package com.example.demo.Resource;

import com.example.demo.Model.Clock;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ClockResource {
    Clock clock;

    @GetMapping(value = "/getTime", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getTimeWithParam(@RequestParam("time") String time){
        HashMap<String, String> response = new HashMap<>();
        if(!Clock.validate(time))
            response.put("errorMessage", "Invalid input");
        else{
            Clock clock = new Clock(time);
            response.put("response", clock.toString());
        }
        return response;
    }

    @GetMapping(value = "/getTimeWithBody", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getTime(@RequestBody String requestBody){
        HashMap<String, String> response = new HashMap<>();
        if(!Clock.validate(requestBody))
            response.put("errorMessage", "Invalid input");
        else{
            Clock clock = new Clock(requestBody);
            response.put("response", clock.toString());
        }
        return response;
    }
}
