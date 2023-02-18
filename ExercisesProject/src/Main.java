import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args)  {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = new AnchorPane() ;
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
	}

}
