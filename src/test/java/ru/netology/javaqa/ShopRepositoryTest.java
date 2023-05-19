package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void removeByIdSuccess() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Футболка", 1000);
        Product product2 = new Product(2, "Книга", 450);

        repository.add(product1);
        repository.add(product2);

        repository.removeById(1);

        Product[] products = repository.findAll();

        Product expected = product2;
        Product actual = products[0];

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeByIdNotFound() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(1, "Футболка", 1000);

        repository.add(product);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(2);
        });
    }

    @Test
    public void findByIdSuccess() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Футболка", 1000);
        Product product2 = new Product(2, "Книга", 450);

        repository.add(product1);
        repository.add(product2);

        Product expected = product2;
        Product actual = repository.findById(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIdNotFound() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Футболка", 1000);
        Product product2 = new Product(2, "Книга", 450);

        repository.add(product1);
        repository.add(product2);

        Product expected = null;
        Product actual = repository.findById(3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addSuccess() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(1, "Футболка", 1000);

        repository.add(product);

        Product[] products = repository.findAll();

        Product expected = product;
        Product actual = products[0];

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addAlreadyExists() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Футболка", 1000);
        Product product2 = new Product(1, "Книга", 450);

        repository.add(product1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(product2);
        });
    }
}

