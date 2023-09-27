package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.Productdto;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ProductService")
@Lazy
public class ProductService implements IProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Productdto queryProduct(Productdto productdto) {
        Product product = ProductMapper.INSTANCE.toEntity(productdto);
        Product productFinal= this.productDao.getReferenceById(product.getId());
        return ProductMapper.INSTANCE.toDTO(productFinal);

    }

    @Override
    public List<Productdto> queryAllProducts() {
        return ProductMapper.INSTANCE.toDTOList(this.productDao.findAll());
    }

    @Override
    public int insertProduct(Productdto productdto) {
        Product product = ProductMapper.INSTANCE.toEntity(productdto);
        this.productDao.saveAndFlush(product);
        return product.getId();
    }

    @Override
    public int updateProduct(Productdto productdto) {
        return this.insertProduct(productdto);
    }

    @Override
    public int deleteProduct(Productdto productdto) {
       int id = productdto.getId();
       Product product = ProductMapper.INSTANCE.toEntity(productdto);
       this.productDao.delete(product);
       return id;
    }
}
