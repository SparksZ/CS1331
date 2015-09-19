import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
* This class is a JavaFX application for G(arbage)Mail
* @author Zack Sparks
* @version 1.0
*/
public class MailReader extends Application {
    private static BorderPane border;
    private MessagesWindow messWin;
    private ObservableList<String> messList;

    /**
    * @param args command line arguments
    */
    public static void main(String[] args) {
        launch(args);
    }

    /**
    * @return the header for application with dem buttons.
    */
    public HBox addHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(15, 12, 15, 12));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #555555;");

        Button refresh = new Button();
        refresh.setText("Refresh Yo Self!");
        refresh.setOnAction(e -> {
                messWin.refresh();
            });

        Button senderSort = new Button();
        senderSort.setText("Sort by Sender");
        senderSort.setOnAction(e -> {
                messWin.senderSort();
                messList = messWin.getObsList();
            });

        Button dateSort = new Button();
        dateSort.setText("Sort by Date");
        dateSort.setOnAction(e -> {
                messWin.dateSort();
                messList = messWin.getObsList();
            });

        Button subjectSort = new Button();
        subjectSort.setText("Sort by Subject");
        subjectSort.setOnAction(e -> {
                messWin.subSort();
                messList = messWin.getObsList();
            });

        Button trash = new Button();
        trash.setText("Trash Message!");
        trash.setOnAction(e -> {
                messWin.trashSelected();
                messList = messWin.getObsList();
            });
        //trash.disableProperty().bind(Bindings)

        Button flag = new Button();
        flag.setText("Flag Important!");
        flag.setOnAction(e -> {
                messWin.flagSelected();
                messList = messWin.getObsList();
            });

        header.getChildren().addAll(refresh, senderSort, dateSort,
            subjectSort, trash, flag);

        return header;
    }

    /**
    * @return the pane with the mailboxes
    */
    public VBox mailBoxes() {
        VBox mailboxes = new VBox();
        mailboxes.setPadding(new Insets(5));
        mailboxes.setSpacing(4);

        Text title = new Text("Mail Boxes");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        mailboxes.getChildren().add(title);

        ListView<String> list = new ListView<>();
        ObservableList<String> boxes = FXCollections.observableArrayList(
            "Inbox", "Important", "Trash");
        list.setItems(boxes);

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                border.setCenter(messWin.messageList(list.
                    getSelectionModel().getSelectedItem()));
            }
        });

        mailboxes.getChildren().add(list);

        return mailboxes;
    }

    /**
    * This method sets, primes and shows the stage.
    * @param stage the stage that is to be set.
    */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("G(arbage)Mail");
        messWin = new MessagesWindow();
        messList = messWin.getObsList();

        //Create UI Controls
        border = new BorderPane();
        HBox header = addHeader();

        //Add UI Controls to Parent Node
        border.setTop(header);
        border.setLeft(mailBoxes());
        border.setCenter(messWin.messageList("Inbox"));
        border.setRight(messWin.displayMessage(messWin.getMSendSub().get(0)));

        //Set up and show stage
        Scene scene = new Scene(border);
        stage.setHeight(600);
        stage.setWidth(1250);
        stage.setScene(scene);
        stage.show();
    }

    /**
    * @return the borderPane to be edited by other classes.
    */
    public static BorderPane getBorder() {
        return border;
    }
}
