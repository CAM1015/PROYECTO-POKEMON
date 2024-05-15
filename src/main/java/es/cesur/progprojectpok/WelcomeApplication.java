package es.cesur.progprojectpok;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
/*
        // Obtener la conexión con MySQL
        Connection connection = DBConnection.getConnection();

        // Preparar una consulta
        String sql = "SELECT * FROM PRODUCTO";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            // Ejecutar la consulta
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){    // Mientras que haya fila, recorre las filas
                int idProducto = resultSet.getInt("ID_PRODUCTO");
                String nombreProducto = resultSet.getString("NOMBRE");

                System.out.println(idProducto + " " + nombreProducto);
            }


        } catch (SQLException e) {
            System.err.println("HelloApplication - start - Error al preparar la sentencia SQL.");
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println("HelloApplication - start - Error al conectar con base de datos.");
            }
        }




        // Cerrar conexiones




*/

/*
        UserManager userManager = new UserManager();
        Boolean loginOk = userManager.login("miguel 2", "1234");
        System.out.println(loginOk);

        User user = new User("angel 3", "123456", false, "angel2@email.es");
        userManager.signIn(user);
        user = new User("angel", "1234", false, "angel2@email.es");
        userManager.deleteUser(user);
        user = new User("angel 3", "123456", false, "angel2@email.es");
        userManager.updateUser(user);

        */
/*
        UserDAOJDBC userDAOJDBC = new UserDAOJDBC();
        User user = userDAOJDBC.findById(1);
        userDAOJDBC.save(new User("miguelangel", "1234", false, "miguelangel@email.es"));
        userDAOJDBC.save(new User("miguelangel2", "1234", false, "miguelangel2@email.es"));
        //userDAOJDBC.delete(1);
        user = userDAOJDBC.findByUsernameAndPassword("miguelangel", "1234");
        user.setEmail("miguelangelactualizado@email.es");
        userDAOJDBC.update(user);*/


        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeApplication.class.getResource("view/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 751, 475);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}