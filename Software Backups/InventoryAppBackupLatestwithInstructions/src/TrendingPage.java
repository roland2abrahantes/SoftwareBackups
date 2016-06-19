import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class TrendingPage extends BorderPane {

	Login login;
	
	public TrendingPage(Login login){
		
		this.login = login;
		
		Button goBack = new Button("Go Back");
        goBack.setMaxWidth(140);
        
        VBox hBox = new VBox();
		hBox.setMinWidth(400);
		hBox.setMinHeight(100);
		hBox.setSpacing(1);
		hBox.setAlignment(Pos.TOP_CENTER);
		hBox.setPadding(new Insets(30,30,30,30));
		hBox.getChildren().add(goBack); 
        
		
		 ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("Hair Products", 13),
	                new PieChart.Data("Makeup", 25),
	                new PieChart.Data("Lipstick", 10),
	                new PieChart.Data("Conditioner", 22),
	                new PieChart.Data("By Brand", 30));
	        final PieChart chart = new PieChart(pieChartData);
	        chart.setTitle("Beauty Items");
		
		    VBox centerBox = new VBox();
			centerBox.setMinWidth(400);
			centerBox.setMinHeight(100);
			centerBox.setSpacing(1);
			centerBox.setAlignment(Pos.TOP_CENTER);
	//		hBox.setPadding(new Insets(30,30,30,30));
			centerBox.getChildren().add(chart); 
		
		
		


		
		
		
		
        
        goBack.setOnAction((e) -> {

			login.theStage.setScene(login.scene3);
			login.userID.clear();
			login.userPasswordField.clear();


		});
		
        setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
        super.setCenter(centerBox);
        super.setBottom(hBox);
	}
	
	
}
