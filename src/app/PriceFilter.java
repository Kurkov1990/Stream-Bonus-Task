package app;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PriceFilter implements ProductFilter {
    private double maxPrice;

    public PriceFilter(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Product> filter(List<Product> products) {

        if (products == null || products.isEmpty()) {
            return Collections.emptyList();
        }

        if (maxPrice == 0) {
            return products.stream()
                    .filter(p -> p.getPrice() <= 0)
                    .collect(Collectors.toList());
        }

        return products.stream()
                .filter(p -> p.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}