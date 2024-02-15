package controller;

import model.Dictionary;
import view.DictionaryView;

public class DictionaryController {
    private Dictionary dictionary = new Dictionary();
    private DictionaryView view;
    public DictionaryController(DictionaryView view) {
        this.view = view;
    }

    public static void main(String[] args) {
        DictionaryView.launch(DictionaryView.class);
    }
    public void addWord(String word, String meaning){
        dictionary.setWord(word, meaning);
    }
    public void searchWord(){
       String word = view.getWordFromTextField();
       String meaning = dictionary.getWord(word);
       view.setWordMeaning(meaning);
    }
}