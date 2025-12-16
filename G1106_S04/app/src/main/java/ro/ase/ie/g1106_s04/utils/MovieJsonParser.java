package ro.ase.ie.g1106_s04.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ro.ase.ie.g1106_s04.model.Movie;
import ro.ase.ie.g1106_s04.model.ParentalGuidanceEnum;

public class MovieJsonParser {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    public static List<Movie> fromJson(String jsonString) {
        List<Movie> movies = null;

        if(jsonString!= null)
        {
            movies = new ArrayList<>();
            try {
                JSONArray array = new JSONArray(jsonString);
                for(int index = 0; index < array.length(); index++)
                {
                    JSONObject jsonObject = array.getJSONObject(index);
                    Movie movie = readMovie(jsonObject);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        }
        return movies;
    }

    private static Movie readMovie(JSONObject jsonObject) throws JSONException {
        String title = jsonObject.getString("title");
        String genre = jsonObject.getString("genre");
        Double budget = jsonObject.getDouble("budget");

        return new Movie();
    }


}
