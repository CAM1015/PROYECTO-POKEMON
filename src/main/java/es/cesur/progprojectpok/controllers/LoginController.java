package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.SplashApplication;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.model.Entrenador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Stage stage;

    @FXML
    private ImageView imgFondoLogin;

    @FXML
    private TextField txtFieldUsername;

    @FXML
    private PasswordField passField;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnLogIn;

    @FXML
    private Label lblError;

    @FXML
    private Label lblErrorExistencia;

    @FXML
    private Label lblRegistro;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUsername;



    @FXML
    public void onSignUpClick(ActionEvent event) {
        try {
            String EnteredUsername = txtFieldUsername.getText();
            String EnteredPassword = passField.getText();

            Connection connection = DBConnection.getConnection();
            String sql="SELECT PASS, NOM_ENTRENADOR FROM ENTRENADOR";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    String PASS = resultSet.getString("PASS");
                    String NOM_ENTRENADOR = resultSet.getString("NOM_ENTRENADOR");

                    System.out.println(PASS + " " + NOM_ENTRENADOR);


                    if (EnteredUsername.equals(NOM_ENTRENADOR)) {
                        System.out.println("Este usuario ya existe.");
                        lblErrorExistencia.setText("Este usuario ya existe.");
                        lblErrorExistencia.setVisible(true);
                        break;

                    } else {
                        String sql2 = ("INSERT INTO `ENTRENADOR`(`NOM_ENTRENADOR`, `PASS`, `POKEDOLLARS`) VALUES ('" + EnteredUsername + "','" + EnteredPassword + "', 5000)");
                        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                        int result = preparedStatement2.executeUpdate();

                        System.out.println("Usuario registrado con exito");
                        lblRegistro.setText("Usuario registrado con exito");
                        lblRegistro.setVisible(true);
                        break;
                    }
                }
            } catch (SQLException e) {
                System.err.println("LoginController - start - error al preparar la sentencia SQL");
            }
        } catch (NullPointerException e) {
            System.out.println("LoginController NullPointerException al Conectar Pantallas");
        }
    }



    @FXML
    public void onLogInClick(ActionEvent event) {


        if (txtFieldUsername.getText().isEmpty()) {
            lblError.setText("Usuario o contraseña incorrectos.");
            lblError.setVisible(true);
        } else if (passField.getText().isEmpty()) {
            lblError.setText("Usuario o contraseña incorrectos.");
            lblError.setVisible(true);
        } else {
            String usuario = txtFieldUsername.getText();
            String pass = passField.getText();

            Connection connection = DBConnection.getConnection();
            String sql = "SELECT ID_ENTRENADOR, NOM_ENTRENADOR FROM ENTRENADOR WHERE NOM_ENTRENADOR = ? AND PASS = ?";


            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, usuario);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();

                Entrenador entrenador = new Entrenador(usuario, pass);

                if (rs.next()) {
                    int idEntrenador = rs.getInt("ID_ENTRENADOR");
                    String nombreEntrenador = rs.getString("NOM_ENTRENADOR");

                    SesionController sesionController = SesionController.getInstance();
                    sesionController.setEntrenadorId(idEntrenador);
                    sesionController.setNombreEntrenador(nombreEntrenador);

                    Stage loginStage = (Stage) btnLogIn.getScene().getWindow();
                    loginStage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("es/cesur/progprojectpok/view/menu-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 751, 475);
                    Stage primaryStage = new Stage();
                    primaryStage.setTitle("Menu");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }else {

                    lblError.setText("Usuario o contraseña incorrectos.");
                    lblError.setVisible(true);
                }

            } catch (SQLException e) {
                System.err.println("LoginController - start - error al preparar la sentencia SQL");
            } catch (NullPointerException | IOException e) {
                System.out.println("LoginController NullPointerException al Conectar Pantallas");
            }
            }

        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}






/*
    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuarios = new ArrayList<>();
        usuarios.add(new User("miguel", "1234", true, null));
        usuarios.add(new User("angel", "5678", false, null));

        userDAOJDBC = new UserDAOJDBC();

    }

    @FXML
    protected void onActionBtnLogin() {
        String username = txtFieldUsername.getText();
        String pass = passField.getText();

        Boolean result = validarUsuario(username, pass);

        User user = userDAOJDBC.findByUsernameAndPassword(username, pass);
    }

    List<User> usuarios;

    UserDAOJDBC userDAOJDBC;

    /**
     * Método para validar un usuario.
     * @param username nombre del usuario.
     * @param pass password del usuario.
     * @return verdadero o falso según exista o no el usuario.

    public Boolean validarUsuario(String username, String pass) {
        //User usuarioConsultado = consultarBaseDatos(username, pass);

        for (User user : usuarios) {
            if (username.equals(user.getUsername()) && pass.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }


}
*/