package tienda.tenda_online;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String name,
            String description
    );

    default List<Product> search(String query) {
        return findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
    }
}