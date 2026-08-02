package com.survey.FielReader;



import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public static String readJsonvalue(String jsobObject, String jsonKey)
    {
        String filePath = System.getProperty("user.dir")+"";
        String jsonvalue = "";

        File fi = new File(filePath);
        try(FileReader fr = new FileReader(fi)){
            JSONTokener jt = new JSONTokener(fr);
            JSONObject data = new JSONObject(jt);
            JSONObject nestedObject =data.getJSONObject(jsobObject);

            Object value = nestedObject.get(jsonKey);

            if(value instanceof JSONArray)
            {
                JSONArray array = (JSONArray)value;
                List<String> items = new ArrayList<>();
                for(int i=0; i<array.length(); i++)
                {
                    items.add(array.getString(i));
                }
                jsonvalue = String.join(", ", items);
            }else{
                jsonvalue= nestedObject.getString(jsonKey);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonvalue;
    }
}
