
public class MailBoxChoice {

    private BorderPane mainPane = MailReader.getBorder();

    public mailBoxChoice() {
        mainPane.
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
}
