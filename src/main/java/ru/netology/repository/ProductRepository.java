package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

public class ProductRepository {

    protected Product[] products = new Product[0];

    public void save(Product newProduct) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = newProduct;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }


    public void removeById(int removeId) {
        if (products.length != 0) {
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[i].getId() != removeId) {
                    if (copyToIndex + 1 == products.length) {
                        return;
                    }
                    tmp[copyToIndex] = products[i];
                    copyToIndex++;
                }
            }
            products = tmp;
        }
    }



}