package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichData = new JSONObject(json);
            JSONObject name = sandwichData.getJSONObject("name");
            String mainName = name.getString("mainName");
            List<String> alsoKnownAs = jsonArrayToStringList(name.getJSONArray("alsoKnownAs"));
            String placeOfOrigin = sandwichData.getString("placeOfOrigin");
            String description = sandwichData.getString("description");
            String image = sandwichData.getString("image");
            List<String> ingredients = jsonArrayToStringList(sandwichData.getJSONArray("ingredients"));
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> jsonArrayToStringList(JSONArray jsonArray) throws JSONException {
        List<String> stringList = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            stringList.add(jsonArray.getString(i));
        }
        return stringList;
    }
}