package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.model.Product;
import es.cesur.progprojectpok.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public static final String PATH_IMG_FONDO = Utils.PATH_BASE_SOURCES + "/images/fondoplaya.png";
    public static final String PATH_IMG_CRIATURA = Utils.PATH_BASE_SOURCES + "/images/criatura-planta.png";
    public static final String PATH_IMG_CRIATURA2 = Utils.PATH_BASE_SOURCES + "/images/criatura-rayo.png";

    @FXML
    private Label welcomeText;

    @FXML
    private ImageView imgViewEjemplo;

    @FXML
    private ComboBox<String> comboBoxColores;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button btnHello;


    @FXML
    private TableView<ImageData> tableView;

    @FXML
    private TableColumn<ImageData, String> imageColumn;
    @FXML
    private TableColumn<ImageData, String> nameColumn;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label lblComunidades;

    @FXML
    private Button btnSaveDB;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // ComboBox: selecciona un valor por defecto
        comboBoxColores.getItems().addAll("Opción 1", "Opción 2", "Opción 3");
        comboBoxColores.getSelectionModel().select("Opción 2");

        // ImageView: establece una imagen por defecto

        File fileImageFondo = new File(PATH_IMG_FONDO);
        imgViewEjemplo.setImage(new Image(fileImageFondo.getAbsolutePath()));


        // Slider: establece un valor por defecto
        progressBar.setProgress(0.5);

        listView.getItems().addAll("Elemento 1", "Elemento 2", "Elemento 3");


        // Configura la columna de nombre como normal
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Configura la columna de imagen para mostrar una ImageView
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("imagePath"));
        imageColumn.setCellFactory(tc -> new TableCell<ImageData, String>() {
            private final ImageView imageView = new ImageView();

            {
                imageView.setFitHeight(50); // Ajusta a tus necesidades
                imageView.setFitWidth(50);
            }

            @Override
            protected void updateItem(String imagePath, boolean empty) {
                super.updateItem(imagePath, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    File fileImageFondo = new File(imagePath);
                    imageView.setImage(new Image(fileImageFondo.getAbsolutePath()));
                    setGraphic(imageView);
                }
            }
        });

        // Ejemplo de cómo añadir datos
        tableView.getItems().add(new ImageData(PATH_IMG_CRIATURA, "Criatura"));
        // Añade más datos según sea necesario


    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");


        tableView.getItems().add(new ImageData(PATH_IMG_CRIATURA2, "Criatura 2"));

        listView.getItems().add("Elemento 4");

        progressBar.setProgress(0.1);
        progressBar.setStyle("-fx-accent: red;");

        comboBoxColores.getItems().add("Opción 4");
        comboBoxColores.getSelectionModel().select("Opción 4");

        lblComunidades.setText("Comunidades autónomas modificado");
    }


    @FXML
    protected void onActionBtnSaveDB() {
        // Obtener la conexión con MySQL
        Connection connection = null;


        String sql = "INSERT INTO producto (NOMBRE, DESCRIPCION, ALMACENABLE, MAXIMO_STOCK, PRECIO) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            connection = DBConnection.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "Nombre 1");
            pstmt.setString(2, "Descripción 1");
            pstmt.setBoolean(3, true);

            pstmt.setInt(4, 4);

            pstmt.setDouble(5, 20.5);


            int affectedRows = pstmt.executeUpdate();
            System.out.println("Filas afectadas: " + affectedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println("HelloApplication - start - Error al conectar con base de datos.");
            }
        }
    }

    @FXML
    protected void onActionBtnLoadDB() {

        Connection connection = null;
        String sql = "SELECT * FROM producto where ID_PRODUCTO = ?";
        PreparedStatement pstmt = null;
        List<Product> productos = new ArrayList<>();
        ResultSet rs = null;

        try {
            connection = DBConnection.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 3);

            rs = pstmt.executeQuery();
            while (rs.next()) {
               Product prod = new Product(
                        rs.getInt("ID_PRODUCTO"),
                        rs.getString("NOMBRE"),
                        rs.getString("DESCRIPCION"),
                        rs.getBoolean("ALMACENABLE"),
                        rs.getInt("MAXIMO_STOCK"),
                        rs.getDouble("PRECIO")
                );
               productos.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println("HelloApplication - start - Error al conectar con base de datos.");
            }
        }

        for (Product producto: productos) {
            System.out.println(producto.toString());
        }

        // Cerrar Ventana actual
        // Obtener el escenario (stage) de uno de los componentes de esta vista
        Stage stageAnterior = (Stage) welcomeText.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/login-view.fxml"));
        Scene scene = null;
        Stage newStage = new Stage();
        try {
            scene = new Scene(fxmlLoader.load(), 824, 827);
            newStage.setTitle("Login");
            newStage.setScene(scene);
            newStage.show();

            stageAnterior.close();

        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }



    }






    /* PARA PRUEBAS, SE PUEDE MOCKEAR LA BD

    import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;

public class TiendaController {

    @FXML
    private ListView<String> listaDisponibles;
    @FXML
    private ListView<String> listaSeleccionados;
    @FXML
    private Button btnAgregar;

    private DatabaseService databaseService;

    public TiendaController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @FXML
    private void initialize() {
        listaDisponibles.setItems(databaseService.fetchAvailableProducts());
        listaSeleccionados.setItems(FXCollections.observableArrayList());
        btnAgregar.setOnAction(e -> moverProducto());
    }

    private void moverProducto() {
        String seleccionado = listaDisponibles.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaDisponibles.getItems().remove(seleccionado);
            listaSeleccionados.getItems().add(seleccionado);
            databaseService.saveSelectedProduct(seleccionado);
        }
    }
}


     */
}