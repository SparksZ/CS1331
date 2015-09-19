
public class HeaderMaker {

    /**
    * @return the header for application with dem buttons.
    */
    public static HBox addHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(15, 12, 15, 12));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #996633;");

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
        trash.setText("Trash dis Txt!");
        trash.setOnAction(e -> {
                messWin.trashSelected();
                messList = messWin.getObsList();
            });
        //trash.disableProperty().bind(Bindings)

        Button flag = new Button();
        flag.setText("dis of Consequence!");
        flag.setOnAction(e -> {
                messWin.flagSelected();
                messList = messWin.getObsList();
            });

        header.getChildren().addAll(refresh, senderSort, dateSort,
            subjectSort, trash, flag);

        return header;
    }
}
