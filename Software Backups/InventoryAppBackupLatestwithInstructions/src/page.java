import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class page extends BorderPane{

	public page(){
		
		Button one = new Button("Ho");
		VBox hbox = new VBox();
		hbox.getChildren().add(one);
		
		super.setTop(hbox);
	}
	
	
}
