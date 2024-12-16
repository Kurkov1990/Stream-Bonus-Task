package app;

import java.util.List;

public class ProductProcessor {

    public double calculateTotalPrice(List<Product> products) {

        if (products == null || products.isEmpty()) {
            return 0.0;
        }

        return products.stream()
                .filter(product -> product.getPrice() > 0) // Пропускаємо продукти з ціною > 0
                .mapToDouble(Product::getPrice)
                .sum();
    }
}