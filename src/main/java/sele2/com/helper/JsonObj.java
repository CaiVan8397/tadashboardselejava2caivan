package sele2.com.helper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class JsonObj {
//    JSON to generic object
    public <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }

//    JSON to list of generic objects
    public <T> List<T> fromJsonAsList(String json, Class<T[]> clazz) {
        return Arrays.asList(new Gson().fromJson(json, clazz));
    }
}
