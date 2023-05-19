package ru.netology.javaqa;

public class Main {
    public static void main(String[] args) {

        ShopRepository repository = new ShopRepository();

        repository.add(new Product(1, "Футболка", 1000));
        repository.add(new Product(2, "Книга", 450));

        Product[] products = repository.findAll();
        for (Product product : products) {
            System.out.println(product.getTitle() + " стоит " + product.getPrice());
        }
    }
}
// хотела просто для себя проверить, как выводит консоль