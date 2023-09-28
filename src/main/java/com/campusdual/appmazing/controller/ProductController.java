package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.dto.Productdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public String testController(){
        return "Products controller works!";
    }

    @PostMapping
    public String testControllerBody(@RequestBody String name){
        return "Products controller works," + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerMethod(){
        return "Product controller method works";
    }

    @PostMapping(value="/get")
    public Productdto queryProduct(@RequestBody Productdto product){
      return this.productService.queryProduct(product);
    }

    @GetMapping(value = "/getAll")
    public List<Productdto> queryAllProducts(){
        return this.productService.queryAllProducts();
    }
    @PostMapping(value= "/add")
    public int insertProduct(@RequestBody Productdto product){
        return this.productService.insertProduct(product);
    }
    @PutMapping(value= "/update")
    public int updateProduct(@RequestBody Productdto product){
        return this.productService.updateProduct(product);
    }
    @DeleteMapping(value ="/delete")
    public int deleteProduct(@RequestBody Productdto product){
        return this.productService.deleteProduct(product);
    }
}
