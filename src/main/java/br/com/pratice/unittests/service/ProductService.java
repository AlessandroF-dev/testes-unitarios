package br.com.pratice.unittests.service;

import br.com.pratice.unittests.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    /**
     * É responsável por receber uma request, setar os campos
     * no response e devolver o response
     */

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

    /**
     * É responsável por receber um preço e uma lista de produtos e a partir dessa lista
     * filtrar o primeiro registro com aquele preço passado
     */

    public ProductDTO getFirstByPrice(double price, List<ProductDTO> productDTOList) {

        for (ProductDTO productDTO:productDTOList) {
            System.out.println(productDTO.getName());
        }
        return productDTOList
                .stream()
                .filter(productDTO -> productDTO.getPrice() == price)
                .findFirst()
                .orElse(new ProductDTO());
    }

    /**
     * Deve validar se o preço é maior que 0, caso seja menor, deve retornar um false
     * e impedir que o produto seja criado;
     */

    public boolean validatePrice(double price) {
        if (price > 0) {
            return true;
        }else{return false;
        }
    }
}
