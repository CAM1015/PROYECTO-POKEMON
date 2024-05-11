package es.cesur.progprojectpok.services;

import es.cesur.progprojectpok.daos.ProductDAO;
import es.cesur.progprojectpok.model.Product;

public class ProductService {

    private ProductDAO productDao;

    public ProductService() {
        productDao = new ProductDAO();
    }

    public Product findProduct(int id) {
        return productDao.findById(id);
    }

    public Boolean saveProduct(Product product) {
        return productDao.save(product);
    }

/*    public void deleteProduct(Product product) {
        productDao.delete(product);
    }

    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    public Product findAutoById(int id) {
        return productDao.findAutoById(id);
    }*/


    public Boolean deleteProduct(Product product) {
        return productDao.deleteProduct(product.getId());
    }

    public Boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }
}
