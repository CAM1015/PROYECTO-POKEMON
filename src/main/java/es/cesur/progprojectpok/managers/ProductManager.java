package es.cesur.progprojectpok.managers;

import es.cesur.progprojectpok.services.ProductService;
import es.cesur.progprojectpok.services.UserService;

public class ProductManager {
    private ProductService productService;

    public ProductManager(){
        productService = new ProductService();
    }

}
