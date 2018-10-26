
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author Eduardo
 */
public class Index extends Application {
    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage mainStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("visao/Login.fxml"));
        
        scene = new Scene(root);
        scene.getStylesheets().add("/ticket/visao/estilos.css");
        
        stage = mainStage;
        stage.setScene(scene);
        stage.show();
    }
}
