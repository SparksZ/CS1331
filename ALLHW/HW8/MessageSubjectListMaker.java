import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MessageSubjectListMaker {
    //
    // private static Server getServed;
    // private static String activeBox;
    // private static Mailbox inbox;
    // private static Mailbox important;
    // private static Mailbox trash;
    // private static ListView<String> list;
    // private static ObservableList<String> mSendSub;
    // private static VBox mBox;
    // private static DateTimeFormatter formatter = DateTimeFormatter.
    //     ofPattern("yyyy-MM-dd hh:mm");
    //
    // /**
    // * Returns the message list pane
    // * @param boxName this specifies which mailbox that is to be used
    // * @return the VBox with the message list that is to be the pane in the main
    // *   application.
    // */
    public static VBox messageList(String boxName) {

        getServed = new Server();
        inbox = new Mailbox("Inbox", getServed.getMessages(10));
        important = new Mailbox("Important",
            new ArrayList<Message>());
        trash = new Mailbox("Trash", new ArrayList<Message>());
        list = new ListView<String>();
        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                MailReader.getBorder().setRight(displayMessage(list.
                    getSelectionModel().getSelectedItem()));
            }
        });

        activeBox = "Inbox";
        mBox = new VBox();

        Mailbox box = this.getActiveBox();
        activeBox = boxName;
        mBox = new VBox();
        mBox.setPadding(new Insets(5));
        mBox.setSpacing(4);

        Text title = new Text("Messages");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        mBox.getChildren().add(title);

        updateMSendSub(box.getMessages());
        list.setItems(mSendSub);

        mBox.getChildren().add(list);
        mBox.setPrefWidth(300);

        return mBox;
    }
    //
    //
    //     // /**
    //     // * Constructs a MessagesWindow object
    //     // */
    //     // public MessagesWindow() {
    //     //     getServed = new Server();
    //     //     inbox = new Mailbox("Inbox", getServed.getMessages(10));
    //     //     important = new Mailbox("Important",
    //     //         new ArrayList<Message>());
    //     //     trash = new Mailbox("Trash", new ArrayList<Message>());
    //     //     list = new ListView<String>();
    //     //     list.setOnMouseClicked(new EventHandler<MouseEvent>() {
    //     //         public void handle(MouseEvent e) {
    //     //             MailReader.getBorder().setRight(displayMessage(list.
    //     //                 getSelectionModel().getSelectedItem()));
    //     //         }
    //     //     });
    //     //
    //     //     activeBox = "Inbox";
    //     //     mBox = new VBox();
    //     // }
    //
    //     /**
    //     * Returns the message list pane
    //     * @param boxName this specifies which mailbox that is to be used
    //     * @return the VBox with the message list that is to be the pane in the main
    //     *   application.
    //     */
    //     public VBox messageList(String boxName) {
    //         Mailbox box = this.getActiveBox();
    //         activeBox = boxName;
    //         mBox = new VBox();
    //         mBox.setPadding(new Insets(5));
    //         mBox.setSpacing(4);
    //
    //         Text title = new Text("Messages");
    //         title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    //         mBox.getChildren().add(title);
    //
    //         updateMSendSub(box.getMessages());
    //         list.setItems(mSendSub);
    //
    //         mBox.getChildren().add(list);
    //         mBox.setPrefWidth(300);
    //
    //         return mBox;
    //     }
    //
    //     /**
    //     * @return the listView of the messages list
    //     */
    //     public ListView<String> getListView() {
    //         return list;
    //     }
    //
    //     /**
    //     * @return the observablelist with the messages in it.
    //     */
    //     public ObservableList<String> getObsList() {
    //         return mSendSub;
    //     }
    //
    //     /**
    //     * Sorts the active mailbox by sender
    //     */
    //     public void senderSort() {
    //         Mailbox sortBox = this.getActiveBox();
    //
    //         ArrayList<Message> mToSort = sortBox.getMessages();
    //         Collections.sort(mToSort, (Message a, Message b) ->
    //             a.getSender().compareTo(b.getSender()));
    //
    //         updateMSendSub(mToSort);
    //         list.setItems(mSendSub);
    //     }
    //
    //     /**
    //     * Sorts the active mailbox by date
    //     */
    //     public void dateSort() {
    //         Mailbox sortBox = this.getActiveBox();
    //
    //         ArrayList<Message> mToSort = sortBox.getMessages();
    //         Collections.sort(mToSort, (Message a, Message b) ->
    //             a.getDate().compareTo(b.getDate()));
    //
    //         updateMSendSub(mToSort);
    //         list.setItems(mSendSub);
    //     }
    //
    //     /**
    //     * Sorts the active mailbox by subject
    //     */
    //     public void subSort() {
    //         Mailbox sortBox = this.getActiveBox();
    //
    //         ArrayList<Message> mToSort = sortBox.getMessages();
    //         Collections.sort(mToSort, (Message a, Message b) ->
    //             a.getSubject().compareTo(b.getSubject()));
    //
    //         updateMSendSub(mToSort);
    //         list.setItems(mSendSub);
    //     }
    //
    //     /**
    //     * Adds a random message to the inbox
    //     */
    //     public void refresh() {
    //         Message addMe = getServed.getMessage();
    //         inbox.getMessages().add(addMe);
    //
    //         updateMSendSub(inbox.getMessages());
    //         list.setItems(mSendSub);
    //     }
    //
    //     /**
    //     * Removes the selected message from the active mailbox and sends it to
    //     *   trash mailbox
    //     */
    //     public void trashSelected() {
    //         String trashMe = list.getSelectionModel().getSelectedItem();
    //         Mailbox theActiveBox = this.getActiveBox();
    //
    //         int i = mSendSub.indexOf(trashMe);
    //         trash.getMessages().add(theActiveBox.getMessages().get(i));
    //
    //         theActiveBox.getMessages().remove(i);
    //         updateMSendSub(theActiveBox.getMessages());
    //         list.setItems(mSendSub);
    //     }
    //
    //     /**
    //     * Leaves the selected message from the active mailbox and sends it to
    //     *   important mailbox
    //     */
    //     public void flagSelected() {
    //         String flagMe = list.getSelectionModel().getSelectedItem();
    //         Mailbox theActiveBox = this.getActiveBox();
    //
    //         int i = mSendSub.indexOf(flagMe);
    //
    //         important.getMessages().add(theActiveBox.getMessages().get(i));
    //         updateMSendSub(theActiveBox.getMessages());
    //         list.setItems(mSendSub);
    //     }
    //
    //     // /**
    //     // * This manages the actual showing of the message in the right pane
    //     // * of the main application window.
    //     // * @param subject this is the line that is visible from the center pane
    //     // *   it is used here to find the corresponding message in the active mailbox
    //     // * @return the VBox with the body of the message
    //     // */
    //     // public VBox displayMessage(String subject) {
    //     //     Mailbox theActiveBox = this.getActiveBox();
    //     //     VBox messageBod = new VBox();
    //     //     messageBod.setPadding(new Insets(5));
    //     //     messageBod.setSpacing(4);
    //     //     messageBod.setPrefWidth(500);
    //     //     HBox messageTitle = new HBox();
    //     //     messageTitle.setPadding(new Insets(15));
    //     //     HBox messageSender = new HBox();
    //     //     messageTitle.setPadding(new Insets(15));
    //     //
    //     //     Message messageToDisplay = theActiveBox.getMessages().get(
    //     //         mSendSub.indexOf(subject));
    //     //     Text title = new Text(messageToDisplay.getSubject() + "\n");
    //     //     title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    //     //     title.setTextAlignment(TextAlignment.CENTER);
    //     //
    //     //     Text senderLine = new Text(messageToDisplay.getSender().getName()
    //     //         + " <" + messageToDisplay.getSender().getEmail() + "> "
    //     //         + messageToDisplay.getDate().format(formatter).toString() + "\n\t");
    //     //     senderLine.setFont(Font.font("Arial", 12));
    //     //
    //     //     messageTitle.getChildren().add(title);
    //     //     messageSender.getChildren().add(senderLine);
    //     //
    //     //     messageBod.getChildren().add(messageTitle);
    //     //     messageBod.getChildren().add(messageSender);
    //     //     Label messageText = new Label(messageToDisplay.getBody());
    //     //     messageText.setPrefWidth(250);
    //     //     messageText.setWrapText(true);
    //     //
    //     //     messageBod.getChildren().add(messageText);
    //     //
    //     //     return messageBod;
    //     // }
    //
    //     /**
    //     * @return the active mailbox
    //     */
    //     private Mailbox getActiveBox() {
    //         Mailbox result;
    //         switch (activeBox) {
    //         case "Important":
    //             result = important;
    //             break;
    //         case "Trash":
    //             result = trash;
    //             break;
    //         default:
    //             result = inbox;
    //             break;
    //         }
    //
    //         return result;
    //     }
    //
    //     /**
    //     * This allows for the order, number of, or any other changes to the ListView
    //     *   in the center pane of the main application
    //     * @param messages this is the ArrayList of Message of the messages that are
    //     *   to be displayed in the center pane
    //     */
    //     private void updateMSendSub(ArrayList<Message> messages) {
    //         mSendSub = FXCollections.observableArrayList();
    //         mSendSub.removeAll();
    //         Mailbox box = this.getActiveBox();
    //
    //         for (Message m : messages) {
    //             String temp = m.getSender().getName() + " <" + m.getSender().
    //                 getEmail() + ">" + m.getDate().format(formatter).toString()
    //                 + "\n\t" + m.getSubject();
    //
    //             mSendSub.add(temp);
    //         }
    //
    //     }

}
