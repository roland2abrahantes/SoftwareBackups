import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class Instructions extends BorderPane{

	Login login;
	
	public Instructions(Login login){
		
      this.login = login;
      Button goBack = new Button("Go Back");
      
      Image roses = new Image(getClass().getResourceAsStream("/res/InstructionsTwo.jpg"));
      
  //    ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/res/beauty.png"),300,300,true,true));
      final TextArea htmlCode = new TextArea();
      htmlCode.setWrapText(true);
  
      ScrollPane scrollPane = new ScrollPane();
      scrollPane.getStyleClass().add("noborder-scroll-pane");
     // scrollPane.setContent(htmlCode);
      scrollPane.setContent(new ImageView(roses));
      scrollPane.setFitToWidth(true);
      scrollPane.setPrefHeight(180);
	
	
      HBox hBox = new HBox(10);
	  hBox.setMinWidth(100);
	  hBox.setMinHeight(100);
	  hBox.setSpacing(1);
	  hBox.setAlignment(Pos.TOP_CENTER);
	  hBox.setPadding(new Insets(30,30,30,30));
	  hBox.getChildren().add(goBack); 
      
	
      goBack.setOnAction((e) -> {
			
		  login.theStage.setScene(login.scene);
		             
		  });
	
      setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
	  super.setCenter(scrollPane);
      super.setBottom(hBox);
      
	}
	
	
	
}
