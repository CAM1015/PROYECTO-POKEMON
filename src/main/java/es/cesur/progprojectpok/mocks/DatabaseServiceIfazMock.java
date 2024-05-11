package es.cesur.progprojectpok.mocks;

import javafx.collections.ObservableList;

public interface DatabaseServiceIfazMock {
    ObservableList<String> fetchAvailableProducts();
    void saveSelectedProduct(String product);
}

