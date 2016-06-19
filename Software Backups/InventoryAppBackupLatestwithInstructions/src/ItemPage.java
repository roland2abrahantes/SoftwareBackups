import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class ItemPage extends BorderPane{

	Login login;

	TextField usernameText;
	TextField passwordText;
	TextField nameText;
	TextField lastNameText;
	TextField addressText;
	TextField ageText;
	
	Database data;

	public ItemPage(Login login){

		this.login = login;
		
		data = new Database();

		Button goBack = new Button("Go Back");
        goBack.setMaxWidth(140);
		Button addItem = new Button("Add Item");
        addItem.setMaxWidth(140);
		
		Label username = new Label("Item ID");
		Label password = new Label("Item Name");
		Label name = new Label("Quantity");
		Label lastName = new Label("Price");
		Label address = new Label("Item Description");
	//	Label age = new Label("Picture");

		usernameText = new TextField();
		passwordText = new TextField();
		nameText = new TextField();
		lastNameText = new TextField();
		addressText = new TextField();
	//	ageText = new TextField();



		ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/res/beauty.png"),300,300,true,true));

		Button one = new Button("Ho");

		VBox hBox = new VBox();
		hBox.setMinWidth(400);
		hBox.setMinHeight(100);
		hBox.setSpacing(1);
		hBox.setAlignment(Pos.TOP_CENTER);
		hBox.setPadding(new Insets(30,30,30,30));
		hBox.getChildren().add(icon); 
		//	hBox.getChildren().add(goBack);



		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10,25,25,25));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(username, 1, 0);
		grid.add(usernameText,2,0);
		grid.add(password,1,1);
		grid.add(passwordText, 2, 1);
		grid.add(name, 1, 2);
		grid.add(nameText, 2, 2);
		grid.add(lastName, 1, 3);
		grid.add(lastNameText, 2, 3);
		grid.add(address, 1, 4);
		grid.add(addressText, 2, 4);
	//	grid.add(age, 1, 5);
	//	grid.add(ageText, 2, 5);
		grid.add(goBack, 1, 7);
		grid.add(addItem, 1, 6);



		goBack.setOnAction((e) -> {

			login.theStage.setScene(login.scene3);
			login.userID.clear();
			login.userPasswordField.clear();


		});
		
		addItem.setOnAction((e) -> {

			 data.createItem(usernameText.getText(), passwordText.getText(), nameText.getText(), lastNameText.getText(), addressText.getText());	
             clearText();

		});


		setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
		super.setCenter(grid);
		super.setTop(hBox);
	}


	
	public void clearText(){
		  usernameText.clear();
		  passwordText.clear();
		  nameText.clear();
		  lastNameText.clear();
		  addressText.clear();
		  ageText.clear();
	}


	
	
}
