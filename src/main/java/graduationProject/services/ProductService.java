package graduationProject.services;

import graduationProject.models.Product;
import graduationProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showListProduct() {
        return productRepository.findAll();
    }

    public Product showProduct(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Transactional
    public void createNewProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void editProduct(int productId, Product product) {
        product.setProductId(productId);
        productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
