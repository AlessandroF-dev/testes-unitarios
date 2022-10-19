package br.com.pratice.unittests.methods;

import br.com.pratice.unittests.dto.ProductDTO;
import br.com.pratice.unittests.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductService productService;

    private ProductDTO request;

    private List<ProductDTO> productDTOS;

    @BeforeEach
    public void setUp() {
        request = new ProductDTO();
        productDTOS = new ArrayList<>();
        this.request.setPrice(8000);
        this.request.setSerialNumber(12123123L);
        this.request.setName("Notebook");
        this.request.setInStockSince(LocalDate.now());
        this.request.setId(123133L);
        this.request.setDescription("Melhor Notebook gamer");
        productDTOS.add(request);

        request = new ProductDTO();
        this.request.setPrice(9000);
        this.request.setSerialNumber(12133123L);
        this.request.setName("Celular");
        this.request.setInStockSince(LocalDate.now());
        this.request.setId(123133L);
        this.request.setDescription("Melhor celular gamer");
        productDTOS.add(request);

        request = new ProductDTO();
        this.request.setPrice(8000);
        this.request.setSerialNumber(12122123L);
        this.request.setName("Pc");
        this.request.setInStockSince(LocalDate.now());
        this.request.setId(123133L);
        this.request.setDescription("Pc gamer");
        productDTOS.add(request);
    }

    @Test
    public void shouldGetFirstByPrice() {
        ProductDTO firstByPrice = productService.getFirstByPrice(8000, productDTOS);
        assertEquals(8000, firstByPrice.getPrice());
    }

    @Test
    public void shouldReturnEmptyIfPriceIsLassOrEqualsZero() {
        request.setPrice(0);
        Optional<ProductDTO> response = productService.create(request);
        assertNotNull(response);
    }

    @Test
    public void shouldCreateProduct() {
        Optional<ProductDTO> response = productService.create(request);

        assertNotNull(response.get());
        assertEquals(request.getInStockSince(), response.get().getInStockSince());
        assertEquals(request.getDescription(), response.get().getDescription());
        assertEquals(request.getId(), response.get().getId());
        assertEquals(request.getName(), response.get().getName());
        assertEquals(request.getPrice(), response.get().getPrice());
        assertEquals(request.getSerialNumber(), response.get().getSerialNumber());
    }

    @Test
    public void shouldReturnEmpty() {
        request.setPrice(0);
        Optional<ProductDTO> response = productService.create(request);
        assertNotNull(response);
        assertEquals(Optional.empty(), response);
    }

    @Test
    public void shouldReturnFalseWhenPriceIsZero() {
        boolean response = productService.validatePrice(0);
        assertFalse(response);
    }

    @Test
    public void shouldReturnTrueWhenPriceIsGreaterThanZero() {
        boolean response = productService.validatePrice(1);
        assertTrue(response);
    }
}
