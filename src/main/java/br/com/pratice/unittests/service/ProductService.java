package br.com.pratice.unittests.service;

import br.com.pratice.unittests.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public Optional<ProductDTO> create(ProductDTO dto) {
        ProductDTO response = new ProductDTO();
        boolean isValid = validatePrice(dto.getPrice());
        if (isValid) {
            response.setDescription(dto.getDescription());
            response.setId(dto.getId());
            response.setPrice(dto.getPrice());
            response.setName(dto.getName());
            response.setInStockSince(dto.getInStockSince());
            response.setSerialNumber(dto.getSerialNumber());

            return Optional.of(response);
        }
        return Optional.empty();
    }

    public ProductDTO getFirstByPrice(double price, List<ProductDTO> productDTOList) {

        for (ProductDTO productDTO : productDTOList) {
            System.out.println(productDTO.getName());
        }
        return productDTOList
                .stream()
                .filter(productDTO -> productDTO.getPrice() == price)
                .findFirst()
                .orElse(new ProductDTO());
    }

    public boolean validatePrice(double price) {
        if (price > 0) {
            return true;
        } else {
            return false;
        }
    }
}
