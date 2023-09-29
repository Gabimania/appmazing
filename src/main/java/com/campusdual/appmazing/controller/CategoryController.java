package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.ICategoryService;
import com.campusdual.appmazing.model.dto.Categorydto;
import com.campusdual.appmazing.model.dto.Contactdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String testController(){
        return "Category controller works!";
    }

    @PostMapping
    public String testCategoryBody(@RequestBody String name){
        return "Category controller works," + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testCategoryMethod(){
        return "Category controller method works";
    }
    @PostMapping(value="/get")
    public Categorydto queryCategory(@RequestBody Categorydto category){
        return this.categoryService.queryCategory(category);
    }

    @GetMapping(value = "/getAll")
    public List<Categorydto> queryAllCategories(){
        return this.categoryService.queryAllCategories();
    }

    @PostMapping(value= "/add")
    public int insertCategory(@RequestBody Categorydto category){
        return this.categoryService.insertCategory(category);
    }

    @PutMapping(value= "/update")
    public int updateCategory(@RequestBody Categorydto category){
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping(value ="/delete")
    public int deleteCategory(@RequestBody Categorydto category){
        return this.categoryService.deleteCategory(category);
    }
}
