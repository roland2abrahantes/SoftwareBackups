

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;


public class Login extends Application{

	Scene scene,scene2,scene3,scene4,scene5;
	String userNameText;
	String userNamePassword;
	Stage theStage;
	//Scene sceneThree;

	TextField userID;
	TextField userPass;
	PasswordField userPasswordField;
	ItemPage ha = new ItemPage(this);
	TrendingPage trending = new TrendingPage(this);
	final double MAX_VALUE = 180;

	CreateAccount accountPage = new CreateAccount(this);
	AccountsInterface InventoryPage;// = new AccountsInterface(this);

	Database data;

	public void start(Stage primaryStage) throws Exception {

		
		   MenuItem menuItem = new MenuItem("Exit");

	        final Menu menu = new Menu("Application");
	        menu.getItems().add(menuItem);

	        MenuBar menuBar = new MenuBar();
	        menuBar.getMenus().add(menu);


	        menuItem.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent e) {
	                Platform.exit();
	            }
	        });
		
		
		

		theStage = primaryStage;
		scene2 = new Scene(accountPage,700,600);
		//	  scene3 = new Scene(bankingPage,700,600);
		scene4 = new Scene(ha,700,600);
		scene5 = new Scene(trending,700,600);

		ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/res/beauty.png"),300,300,true,true));

		Popup pop = new Popup();
		pop.setX(500); 
		pop.setY(300); 
		VBox popPane = new VBox(10);
		popPane.setSpacing(2);
		popPane.setAlignment(Pos.CENTER);
		Button popButton = new Button("Acknowlege");
		Text popText = new Text(0, 10, "The Password or username you have entered is incorrect");
		popText.setFont(Font.font("Courier", FontWeight.BOLD,FontPosture.ITALIC, 15));  
		popText.setFill(Color.BLACK);
		popText.setUnderline(true);
		popPane.getChildren().addAll(popText,popButton);
		pop.getContent().addAll(popPane); 


		Button create = new Button("Create Account");
		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");
		Button btLogin = new Button("Login");
		Button comments = new Button("Add Comments");
		userID = new TextField();
		userPass = new TextField();
		userPasswordField = new PasswordField();

		create.setMaxWidth(100);
		// btLogin.setMaxWidth(Double.MAX_VALUE);
		btLogin.setMaxWidth(100);


		Label userName = new Label("Username");
		Label passWord = new Label("Password");

		//  Create Bottom Panel
		//	  VBox bottomBox = new VBox(10);
		//	  bottomBox.setSpacing(2);
		//	  Text text1 = new Text(0, 10, "For testing purposes only use student as username and password as password");
		//	  text1.setFont(Font.font("Courier", FontWeight.BOLD,FontPosture.ITALIC, 15));  
		//	  text1.setFill(Color.GREEN);
		//	  text1.setUnderline(true);
		//	  bottomBox.getChildren().add(text1);

		//Create the Header Box.
		HBox hBox = new HBox(10);
		hBox.setMinWidth(400);
		hBox.setMinHeight(100);
		hBox.setPadding(new Insets(0,30,30,30));  // new padding created add to all classes
		hBox.setSpacing(60);
		hBox.setAlignment(Pos.TOP_RIGHT);
		hBox.getChildren().add(icon);
		hBox.getChildren().add(menuBar);
		
        

		//Create Main Panel

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(10,25,25,25));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(userName, 1, 0);
		grid.add(passWord,1,1);
		grid.add(btLogin,2,3);
		grid.add(create, 2, 4);
		grid.add(userID, 2, 0);
		grid.add(userPass, 2, 1);
		// grid.setMargin(userID, new Insets(5, 10, 5, 10));
		grid.add(userPasswordField,2,1);
		BorderPane borders = new BorderPane();
		borders.setTop(hBox);
		borders.setLeft(grid);
		borders.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
		//	  borders.setBottom(bottomBox);
      //  borders.getChildren().add(menuBar);

		data = new Database();

		btLogin.setOnAction((e) -> {

			// data.login(userID.getText(),userPass.getText());

			if(data.checkLogin(userID.getText(),userPasswordField.getText()) == true){
				//bankingPage.setCurrentUser(userID.getText());
				InventoryPage = new AccountsInterface(this,userID.getText());
				scene3 = new Scene(InventoryPage,700,600);
				theStage.setScene(scene3);
			}


		});


		create.setOnAction((e) -> {

			accountPage.clearText();
			theStage.setScene(scene2);


		});




		popButton.setOnAction(e -> pop.hide());



		scene = new Scene(borders, 700, 600);
		primaryStage.setTitle("My Beauty Organizer"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();	

	}



	public static void main(String[] args) {
		launch(args);
	}

}