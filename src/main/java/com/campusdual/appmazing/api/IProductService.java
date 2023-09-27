package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.Productdto;

import java.util.List;

public interface IProductService {

    Productdto queryProduct (Productdto product);
    List<Productdto> queryAllProducts();

    int insertProduct (Productdto product);
    int updateProduct (Productdto product);

    int deleteProduct (Productdto product);

}
