package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dto.Productdto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Productdto toDTO(Product product);

    List<Productdto> toDTOList(List<Product> products);
    Product toEntity(Productdto productdto);
}
