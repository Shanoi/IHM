package fr.polytech.ihm;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class JSONParser {

    public JSONObject parse(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(result);
    }

}
