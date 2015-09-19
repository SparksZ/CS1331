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
import javafx.scene.Node;

public class MailBoxChoiceMaker {

    /**
    * @return the pane with the mailboxes
    */
    public static VBox addMailBoxes() {
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
                border.setCenter(MessageSubjectListMaker.messageList(list.
                    getSelectionModel().getSelectedItem()));
            }
        });

        mailboxes.getChildren().add(list);

        return mailboxes;
    }
}
