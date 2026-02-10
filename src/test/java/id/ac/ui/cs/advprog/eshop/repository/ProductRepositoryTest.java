package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void SetUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);
        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity (50);
        productRepository.create(product2);
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProductSuccess() {
        String idProduct = "0001";
        Product productLama = new Product();
        productLama.setProductId(idProduct);
        productLama.setProductName("Basket");
        productLama.setProductQuantity(10);
        productRepository.create(productLama);

        Product productBaru = new Product();
        productBaru.setProductId(idProduct);
        productBaru.setProductName("Basketball");
        productBaru.setProductQuantity(1000);

        Product hasil = productRepository.editProduct(productBaru);
        assertEquals(productLama, hasil);
        assertEquals("Basketball", productLama.getProductName());
        assertEquals(1000, productLama.getProductQuantity());
    }

    @Test
    void testEditProductFail() {
        Product productLama = new Product();
        productLama.setProductId("00001");
        productLama.setProductName("Basket");
        productLama.setProductQuantity(10);
        productRepository.create(productLama);

        Product productGaib = new Product();
        productGaib.setProductId("001");
        productGaib.setProductName("Basketball");
        productGaib.setProductQuantity(1000);

        Product hasil = productRepository.editProduct(productGaib);
        assertNull(hasil);
        assertEquals("Basket", productLama.getProductName());
        assertEquals(10, productLama.getProductQuantity());
    }

    @Test
    void testDeleteProductSuccess() {
        Product productLama = new Product();
        productLama.setProductName("Basket");
        productLama.setProductQuantity(10);
        productRepository.create(productLama);

        assertTrue(productRepository.deleteProduct(productLama.getProductId()));
    }

    @Test
    void testDeleteProductFail() {
        Product productLama = new Product();
        productLama.setProductId("001");
        productLama.setProductName("Basket");
        productLama.setProductQuantity(10);
        productRepository.create(productLama);

        assertFalse(productRepository.deleteProduct("01"));
    }

}
