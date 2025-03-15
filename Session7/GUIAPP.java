import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GUIAPP extends Application {

    private MenuBar mbar;
    private Menu file;
    private MenuItem newFileItem;
    private MenuItem openFileItem;
    private MenuItem saveFileItem;
    private SeparatorMenuItem separatorFile;
    private MenuItem exitFileItem;
    private Menu edit;
    private MenuItem undoEditItem;
    private MenuItem redoEditItem;
    private MenuItem cutEditItem;
    private MenuItem copyEditItem;
    private MenuItem pasteEditItem;
    private MenuItem deleteEditItem;
    private SeparatorMenuItem separatorEdit1,separatorEdit2;
    private MenuItem selectAllEditItem;
    private Menu help;
    private MenuItem aboutAppHelpItem;
    private BorderPane bpane;
    private TextArea textArea;

    @Override
    public void init() throws Exception {
        super.init();
      
        mbar = new MenuBar();
        file = new Menu("File");
        newFileItem = new MenuItem("New");
        newFileItem.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));
        openFileItem = new MenuItem("Open");
        openFileItem.setAccelerator(KeyCombination.keyCombination("Ctrl+o"));
        saveFileItem = new MenuItem("Save");
        saveFileItem.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));
        separatorFile = new SeparatorMenuItem();
        exitFileItem = new MenuItem("Exit");
        exitFileItem.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));

        edit = new Menu("Edit");
        undoEditItem = new MenuItem("Undo");
        undoEditItem.setAccelerator(KeyCombination.keyCombination("Ctrl+u"));
        redoEditItem = new MenuItem("Redo");
        redoEditItem.setAccelerator(KeyCombination.keyCombination("Ctrl+r"));
        separatorEdit1 = new SeparatorMenuItem();
        cutEditItem = new MenuItem("Cut");
        cutEditItem.setAccelerator(KeyCombination.keyCombination("Ctrl+t"));
        copyEditItem = new MenuItem("Copy");
        copyEditItem.setAccelerator(KeyCombination.keyCombination("Ctrl+k"));
        pasteEditItem = new MenuItem("Paste");
        pasteEditItem.setAccelerator(KeyCombination.keyCombination("Ctrl+p"));
        deleteEditItem = new MenuItem("Delete");
        deleteEditItem.setAccelerator(KeyCombination.keyCombination("Ctrl+d"));
        separatorEdit2 = new SeparatorMenuItem();
        selectAllEditItem = new MenuItem("Select All");
        selectAllEditItem.setAccelerator(KeyCombination.keyCombination("Ctrl+l"));

        help = new Menu("help");
        aboutAppHelpItem = new MenuItem("about app");
        
        file.getItems().addAll(newFileItem,openFileItem,saveFileItem,separatorFile,exitFileItem);
        edit.getItems().addAll(undoEditItem,redoEditItem,separatorEdit1,cutEditItem,copyEditItem,pasteEditItem,deleteEditItem,separatorEdit2,selectAllEditItem);
        help.getItems().add(aboutAppHelpItem);
        
        mbar.getMenus().addAll(file,edit,help);

        bpane = new BorderPane();
        bpane.setTop(mbar);
        textArea = new TextArea();
        bpane.setCenter(textArea);
    }

    @Override 
    public void start(Stage primaryStage) throws Exception {
        Scene myScene = new Scene(bpane, 500, 600);
        newFileItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                textArea.clear();
            }
        });
        openFileItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                DirectoryChooser openDialog = new DirectoryChooser();
                openDialog.showDialog(primaryStage);
            }
        });
        saveFileItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                DirectoryChooser saveDialog = new DirectoryChooser();
                saveDialog.showDialog(primaryStage);
            }
        });
        exitFileItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                primaryStage.close();
            }
        });
        undoEditItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                textArea.undo();
            }
        });
        redoEditItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                textArea.redo();
            }
        });
        cutEditItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                textArea.cut();
            }
        });
        copyEditItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                textArea.copy();
            }
        });
        pasteEditItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                textArea.paste();
            }
        });
        deleteEditItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                textArea.replaceSelection("");
            }
        });
        selectAllEditItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                textArea.selectAll();
            }
        });
        aboutAppHelpItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                Alert helpAlert = new Alert(AlertType.INFORMATION);
                helpAlert.setTitle("Mariam's Notepad Info");
                helpAlert.setHeaderText("Help!");
                // helpAlert.setGraphic(bpane);
                helpAlert.setContentText("Hello there, this is Mariam's Notepad!");
                helpAlert.show();

            }
        });
        primaryStage.setScene(myScene);
        primaryStage.setTitle("Mariam's Notepad");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
