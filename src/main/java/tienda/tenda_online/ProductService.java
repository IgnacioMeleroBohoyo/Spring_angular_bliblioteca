package tienda.tenda_online;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> search(String q) {
        if (q == null || q.isBlank()) {
            return List.of();
        }

        return productRepository.search(q.trim());
    }
}