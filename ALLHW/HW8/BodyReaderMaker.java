public class BodyReaderMaker {


    /**
    * This manages the actual showing of the message in the right pane
    * of the main application window.
    * @param subject this is the line that is visible from the center pane
    *   it is used here to find the corresponding message in the active mailbox
    * @return the VBox with the body of the message
    */
    public static VBox displayMessage(String subject) {
        Mailbox theActiveBox = this.getActiveBox();
        VBox messageBod = new VBox();
        messageBod.setPadding(new Insets(5));
        messageBod.setSpacing(4);
        messageBod.setPrefWidth(500);
        HBox messageTitle = new HBox();
        messageTitle.setPadding(new Insets(15));
        HBox messageSender = new HBox();
        messageTitle.setPadding(new Insets(15));

        Message messageToDisplay = theActiveBox.getMessages().get(
            mSendSub.indexOf(subject));
        Text title = new Text(messageToDisplay.getSubject() + "\n");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        title.setTextAlignment(TextAlignment.CENTER);

        Text senderLine = new Text(messageToDisplay.getSender().getName()
            + " <" + messageToDisplay.getSender().getEmail() + "> "
            + messageToDisplay.getDate().format(formatter).toString() + "\n\t");
        senderLine.setFont(Font.font("Arial", 12));

        messageTitle.getChildren().add(title);
        messageSender.getChildren().add(senderLine);

        messageBod.getChildren().add(messageTitle);
        messageBod.getChildren().add(messageSender);
        Label messageText = new Label(messageToDisplay.getBody());
        messageText.setPrefWidth(250);
        messageText.setWrapText(true);

        messageBod.getChildren().add(messageText);

        return messageBod;
    }
}
