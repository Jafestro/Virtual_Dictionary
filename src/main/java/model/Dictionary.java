package model;

import java.util.HashMap;

public class Dictionary {
    private final HashMap<String, String> dictionary = new HashMap<>();

    public void setWord(String word, String meaning){
        dictionary.put(word, meaning);
    }
    public String getWord(String word){
        if (dictionary.containsKey(word))
            return dictionary.get(word);
        else if (word.isBlank()) {
            return "Please enter some word then press a search button";
        } else if (word.matches("\\d+")) {
            return "Please enter a word not your phone number";
        }
        return "Dictionary has not yet have this word, Sorry";
    }
}