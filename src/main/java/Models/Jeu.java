package Models;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Jeu{
    public static Map<String, Joueur> playersMap;
    private static Joueur currentPlayer;

    public Jeu (){
        playersMap = new HashMap<>();
    }

    /*********************** Getters and Setters **********************/


    /************************** Methods ****************************/

    public void addPlyer(String name, Joueur player) {
        playersMap.put(name, player);
    }

    public boolean existPlayer(String name){
        if(playersMap.containsKey(name)) return true;
        return false;
    }

    /*************************** Static Methods **********************************/

    public static void modifyPlayer(String name, Joueur player){
        playersMap.replace(name, player);
    }

    public static void setCurrentPlayer(Joueur player) {
        currentPlayer = player;
    }

    public static Joueur getCurrentPlayer() {
        return currentPlayer;
    }

    public static void Serialization() {
        Gson gson = new Gson();
        try {
            Writer writer = new FileWriter("Players.json");
            gson.toJson(playersMap, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void Deserialization() {
        String json = null;
        Gson gson = new Gson();
        Map<String, Joueur> map;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Players.json"));
            json = reader.lines().collect(Collectors.joining());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;
        map = gson.fromJson(json, Map.class);
        if(map != null) playersMap = map;
    }


}
