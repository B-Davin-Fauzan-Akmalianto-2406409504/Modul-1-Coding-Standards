package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    Product product;
    String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";
    @BeforeEach
    void SetUp() {
        this.product = new Product();
        this.product.setProductId(productId);
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(100);
    }

    @Test
    void createTest() {
        assertEquals(this.product, this.productService.create(this.product));
    }

    @Test
    void findAllTest() {
        this.productRepository.create(this.product);
        List<Product> expected = new ArrayList<>();
        expected.add(this.product);

        Iterator<Product> iterator = expected.iterator();
        when(this.productRepository.findAll()).thenReturn(iterator);

        List<Product> result = this.productService.findAll();
        assertEquals(expected, result);
        assertEquals(this.product, result.get(0));
    }

    @Test
    void findWithIdTest() {
        when(this.productRepository.findWithId(productId)).thenReturn(this.product);
        Product result = this.productService.findWithId(productId);
        assertEquals(this.product, result);
    }

    @Test
    void editProductTest() {
        Product newProduct = new Product();
        newProduct.setProductId(productId);
        newProduct.setProductName("Sampo Cap Ayam");
        newProduct.setProductQuantity(1000);
        when(this.productRepository.editProduct(newProduct)).thenReturn(newProduct);

        Product result = this.productService.editProduct(newProduct);
        assertEquals(newProduct, result);
        assertEquals("Sampo Cap Ayam", result.getProductName());
        assertEquals(1000, result.getProductQuantity());
    }

    @Test
    void deleteProductTest() {
        when(this.productRepository.deleteProduct(productId)).thenReturn(true);
        Boolean result = this.productService.deleteProduct(productId);
        assertEquals(true, result);
    }
}
