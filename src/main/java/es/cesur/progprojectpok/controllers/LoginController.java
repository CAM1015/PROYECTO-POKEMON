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
import java.sql.*;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblError.setVisible(false);
        lblErrorExistencia.setVisible(false);
        lblRegistro.setVisible(false);
    }


    @FXML
    public void onSignUpClick(ActionEvent event) {

        lblError.setVisible(false);
        lblErrorExistencia.setVisible(false);
        lblRegistro.setVisible(false);

        try {
            String enteredUsername = txtFieldUsername.getText().toLowerCase();
            String enteredPassword = passField.getText();

            Connection connection = DBConnection.getConnection();
            String sqlCheckUser = "SELECT NOM_ENTRENADOR FROM ENTRENADOR WHERE NOM_ENTRENADOR = ?";
            PreparedStatement preparedStatementCheckUser = connection.prepareStatement(sqlCheckUser);
            preparedStatementCheckUser.setString(1, enteredUsername);

            ResultSet resultSet = preparedStatementCheckUser.executeQuery();

            if (resultSet.next()) {
                System.out.println("Este usuario ya existe.");
                lblErrorExistencia.setText("Este usuario ya existe.");
                lblErrorExistencia.setVisible(true);
            } else {
                String sqlSelectMaxId = "SELECT MAX(ID_ENTRENADOR) FROM ENTRENADOR";
                Statement statement = connection.createStatement();
                ResultSet resultSet2 = statement.executeQuery(sqlSelectMaxId);

                int lastId = 0;
                if (resultSet2.next()) {
                    lastId = resultSet2.getInt(1);
                }

                int newId = lastId + 1;

                String sqlInsert = "INSERT INTO ENTRENADOR (ID_ENTRENADOR, NOM_ENTRENADOR, PASS, POKEDOLLARS) VALUES (?, ?, ?, 5000)";
                PreparedStatement preparedStatementInsert = connection.prepareStatement(sqlInsert);
                preparedStatementInsert.setInt(1, newId);
                preparedStatementInsert.setString(2, enteredUsername);
                preparedStatementInsert.setString(3, enteredPassword);

                preparedStatementInsert.executeUpdate();

                System.out.println("Usuario registrado correctamente.");
                lblRegistro.setText("Usuario registrado correctamente.");
                lblRegistro.setVisible(true);
            }


            resultSet.close();
            preparedStatementCheckUser.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error al realizar la operación en la base de datos: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException al Conectar Pantallas");
        }
    }



    @FXML
    public void onLogInClick(ActionEvent event) {

        lblError.setVisible(false);
        lblErrorExistencia.setVisible(false);
        lblRegistro.setVisible(false);

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

                    FXMLLoader fxmlLoader = new FXMLLoader(SplashApplication.class.getResource("/es/cesur/progprojectpok/view/menu-view.fxml"));
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