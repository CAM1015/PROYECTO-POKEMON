package es.cesur.progprojectpok.daos;

import es.cesur.progprojectpok.database.HibernateSessionFactoryUtil;
import es.cesur.progprojectpok.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class ProductDAO {

    public ProductDAO() {
    }

    /**
     * Busca un usuario por su identificador.
     *
     * @param id El identificador del usuario.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    public Product findById(int id) {
        Product user = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
        return user;
    }

    /**
     * Guarda un usuario en la base de datos.
     *
     * @param user El usuario a guardar.
     * @return True si el usuario se ha guardado con éxito, false en caso contrario.
     */
    public Boolean save(Product user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Serializable serializable = session.save(user);
        tx1.commit();
        session.close();

        return serializable != null;
    }

/*    public void update(Product user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }*/

/*    public void delete(Product user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }*/

/*    public List<Product> findAll() {
        List<Product> users = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return users;
    }*/

    /**
     * Busca un usuario por su nombre de usuario y contraseña.
     *
     * @param username El nombre de usuario.
     * @param password La contraseña.
     * @return El usuario encontrado que coincide con el nombre de usuario y contraseña proporcionados, o null si no se encuentra ninguno.
     */
    public Product findByProductnameAndPassword(String username, String password) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Product WHERE username = :username AND password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            List<Product> result = query.list();
            if (!result.isEmpty()) {
                return result.get(0); // Retorna el primer usuario que coincida (debería ser único)
            }
            return null; // Ningún usuario encontrado
        } finally {
            session.close();
        }
    }

    public Boolean updateProduct(Product user) {
        return true;
    }

    public Boolean deleteProduct(Integer userId) {

        return true;
    }
}
