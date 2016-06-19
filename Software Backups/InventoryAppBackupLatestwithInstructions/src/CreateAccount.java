import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.paint.Color;

//Assignment:  My Beauty Application
//Author:  Parth Patel
//Course:  ITEC 3860
//Instructor:  Dr. Gunay
//Class: CreateAccount.java

//Description: this is page to createAccount for first time user
//Language:  JAVA

public class CreateAccount extends BorderPane{
 
	Login login;
	
	Database data;
	
	TextField usernameText;
	TextField passwordText;
	TextField nameText;
	TextField lastNameText;
	TextField addressText;
	TextField ageText;
	
	public CreateAccount(Login login){
		
		  this.login = login;
		  data = new Database();
		  
		  Button create = new Button("Create Account");
		  Button goBack = new Button("Go Back");
		  
		  Label username = new Label("Username");
		  Label password = new Label("Password");
		  Label name = new Label("FirstName");
		  Label lastName = new Label("LastName");
		  Label address = new Label("Address");
		  Label age = new Label("Age");
		  
		  usernameText = new TextField();
		  passwordText = new PasswordField();
		  nameText = new TextField();
		  lastNameText = new TextField();
		  addressText = new TextField();
		  ageText = new TextField();
		  
		  
         ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/res/beauty.png"),300,300,true,true));
		  
		  //Create the Header Box.
		  HBox hBox = new HBox(10);
		  hBox.setMinWidth(400);
		  hBox.setMinHeight(100);
		  hBox.setSpacing(1);
		  hBox.setAlignment(Pos.TOP_CENTER);
		  hBox.setPadding(new Insets(30,30,30,30));
		  hBox.getChildren().add(icon); 
		  
		  
		  
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
		  grid.add(age, 1, 5);
		  grid.add(ageText, 2, 5);
		  grid.add(create, 1, 6);
		  grid.add(goBack, 1, 7);
		  
		  setTop(hBox);
		  setCenter(grid);
		
		  
		  create.setOnAction((e) -> {
				
			 data.createAccount(usernameText.getText(), passwordText.getText(), nameText.getText(), lastNameText.getText(), addressText.getText(), ageText.getText());	
			  
			  if(data.createdOk.equalsIgnoreCase("AccountCreated")){
			  login.theStage.setScene(login.scene);
			  }  
			             
			  });
		
		  setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
	
	
		  goBack.setOnAction((e) -> {
				
				  login.theStage.setScene(login.scene);
				  login.userID.clear();
				  login.userPasswordField.clear();
				  
				             
				  });
			
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
