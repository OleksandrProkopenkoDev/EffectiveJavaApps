package ua.spro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ua.spro.controller.MainController;
import ua.spro.controller.SettingsController;
import ua.spro.controller.main.AdminController;
import ua.spro.model.admin.AdminModel;
import ua.spro.model.admin.AdminModelInterface;
import ua.spro.model.user.UserModel;
import ua.spro.model.user.UserModelInterface;


public class ABOAdminApp extends Application {

    public static Stage mainStage;
    public static MainController mainController;

    public static Stage settingsStage;
    public static SettingsController settingsController;

    public static Stage adminStage;
    public static AdminController adminController;

    private static UserModel userModel;
    private static AdminModelInterface adminModel;


    public static UserModel getUserModel() {
        return userModel;
    }

    public static AdminModelInterface getAdminModel() {
        return adminModel;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)   {

        createUtils();
        System.out.println("Utils Created");
        try {
            createMainForm(primaryStage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void createUtils(){
        userModel = new UserModel();
        adminModel = new AdminModel();
    }

    private void createMainForm(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        mainStage.setTitle("ABO Admin");

        FXMLLoader mainLoader = new FXMLLoader();
        mainLoader.setLocation(getClass().getResource("/ua/spro/fxml/mainform.fxml"));
        Parent root = mainLoader.load();

        mainStage.setScene(new Scene(root));
        mainController = mainLoader.getController();
//        mainController.setMainStage(mainStage);
        mainStage.setMinWidth(1200);
        mainStage.setMinHeight(650);




        Image ico = new Image("ua/spro/images/logo.jpg");
        mainStage.getIcons().add(ico);


        settingsStage = new Stage();
        settingsStage.setTitle("Settings");
        settingsStage.setResizable(false);
        settingsStage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader settingsLoader = new FXMLLoader();
        settingsLoader.setLocation(getClass().getResource("/ua/spro/fxml/settings/settingsform.fxml"));
        Parent settingsRoot = settingsLoader.load();

        settingsStage.setScene(new Scene(settingsRoot));
        settingsController = settingsLoader.getController();
//        settingsController.setAdminController(mainController.getAdminController());
//        settingsController.setMainStage(mainStage);
//        settingsController.


        settingsStage.getIcons().add(ico);
        System.out.println("app : controllers created");
//        mainStage.getScene().getStylesheets().add("ua/spro/css/caspian.css");
        mainStage.show();


        settingsStage.setOnCloseRequest(event -> {
//            mainController.
        });
    }
}
