package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.Productdto;

import java.util.List;

public interface IProductService {

    Productdto queryProduct (Productdto productdto);
    List<Productdto> queryAllProducts();

    int insertProduct (Productdto productdto);
    int updateProduct (Productdto productdto);

    int deleteProduct (Productdto productdto);

}
