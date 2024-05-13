package es.cesur.progprojectpok.daos;

import es.cesur.progprojectpok.database.HibernateSessionFactoryUtil;
import es.cesur.progprojectpok.model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

public class UserDAOJDBC {

    public static final String COLNAME_NOM_ENTRENADOR = "username";
    public static final String COLNAME_PASS = "password";
    public static final String COLNAME_ID_ENTRENADOR = "userid";
    private String url = "jdbc:mysql://localhost:3306/proyectopokemon";
    private String user = "root";
    private String password = "";

    public UserDAOJDBC() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Busca un usuario por su identificador.
     *
     * @param id El identificador del usuario.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    public User findById(int id) {
        String query = "SELECT * FROM ENTRENADOR WHERE ID_ENTRENADOR = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getString(COLNAME_NOM_ENTRENADOR), rs.getString(COLNAME_PASS));
                user.setUserId(rs.getInt(COLNAME_ID_ENTRENADOR));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Guarda un usuario en la base de datos.
     *
     * @param user El usuario a guardar.
     * @return True si el usuario se ha guardado con éxito, false en caso contrario.
     */
    public Boolean save(User user) {
        String insert = "INSERT INTO ENTRENADOR (NOM_ENTRENADOR, PASS) VALUES (?, ?)";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

/*    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }*/

/*    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }*/

/*    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }*/

    /**
     * Busca un usuario por su nombre de usuario y contraseña.
     *
     * @param username El nombre de usuario.
     * @param password La contraseña.
     * @return El usuario encontrado que coincide con el nombre de usuario y contraseña proporcionados, o null si no se encuentra ninguno.
     */
    public User findByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM ENTRENADOR WHERE NOM_ENTRENADOR = ? AND PASS = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getString(COLNAME_NOM_ENTRENADOR), rs.getString(COLNAME_PASS));
                user.setUserId(rs.getInt(COLNAME_ID_ENTRENADOR));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean update(User user) {
        String updateSQL = "UPDATE ENTRENADOR SET NOM_ENTRENADOR = ?, PASS = ? WHERE ID_ENTRENADOR = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(5, user.getUserId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int userId) {
        String deleteSQL = "DELETE FROM ENTRENADOR WHERE ID_ENTRENADOR = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, userId);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
