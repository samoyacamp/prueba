package com.mycompany.biblio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.mycompany.biblio.modelos.Usuario;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Usuario user = new Usuario();

    @Override
    public void start(Stage stage) throws IOException {
        String fxml = "primary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 800);
        stage.setScene(scene);
        stage.show();

        // Give the controller access to the main app.
        // LoginController controller = fxmlLoader.getController();
    }

    static void setUsuario(Usuario u) {
        user = u;

    }

    static void loadLibrosWindow() throws IOException {
        String fxml = "secondary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        // Give the controller access to the main app.
        LibroController controller = new LibroController(user);
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.initLists();
        controller.loadImage();
        controller.loadImage1();
        controller.loadImage2();
    }

    static void loadRegisterWindow() throws IOException {
        String fxml = "register";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//        Give the controller access to the main app.
        RegistrarController controller = new RegistrarController(user);
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
//        scene.setRoot(loadFXML(fxml));

    }

    static void loadPrestaWindow() throws IOException {
        String fxml = "presta";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        PrestamoController controller = new PrestamoController(user);
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.initLists();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
