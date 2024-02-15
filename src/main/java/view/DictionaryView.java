package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private DictionaryController controller;
    private TextField textField = new TextField("Enter a word");
    private Button searchButton = new Button("Search");
    private TextArea wordMeaning = new TextArea();
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        primaryStage.setTitle("Dictionary");

        pane.getChildren().add(new Canvas(100.0,200.0));
        pane.getChildren().add(textField);
        pane.getChildren().add(searchButton);
        pane.getChildren().add(wordMeaning);

        Scene view = new Scene(pane);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.searchWord();
            }
        });

        primaryStage.setScene(view);
        primaryStage.show();
    }

    public void init(){
        controller = new DictionaryController(this);
        controller.addWord("flower","is a plant that has a colour and a smell, bees also benefit from it.");
        controller.addWord("oxygen", "is crucial to life, humans breathing with an oxygen");
        controller.addWord("grogu", "is a baby yoda, a small creature, can do telekinesis and talks backwards");
    }

    public String getWordFromTextField(){
        return textField.getText();
    }

    public void setWordMeaning(String meaning) {
        this.wordMeaning.setText(meaning);
    }
    public void cleanUpTheLabel(){
        wordMeaning.setText("");
    }
}
