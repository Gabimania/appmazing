package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.ICategoryService;
import com.campusdual.appmazing.model.Category;
import com.campusdual.appmazing.model.dao.CategoryDao;
import com.campusdual.appmazing.model.dto.Categorydto;
import com.campusdual.appmazing.model.dto.dtomapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("CategoryService")
@Lazy
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public Categorydto queryCategory(Categorydto categorydto){
        Category category = CategoryMapper.INSTANCE.toEntity(categorydto);
        Category categoryFinal = this.categoryDao.getReferenceById(category.getId());
        return CategoryMapper.INSTANCE.toDTO(categoryFinal);
    }

    @Override
    public List<Categorydto> queryAllCategories() {
        return CategoryMapper.INSTANCE.toDTOList(this.categoryDao.findAll());
    }

    @Override
    public int insertCategory(Categorydto categorydto) {
        Category category= CategoryMapper.INSTANCE.toEntity(categorydto);
        this.categoryDao.saveAndFlush(category);
        return category.getId();
    }

    @Override
    public int updateCategory(Categorydto categorydto) {
        return this.insertCategory(categorydto);
    }

    @Override
    public int deleteCategory(Categorydto categorydto) {
        int id = categorydto.getId();
        Category category = CategoryMapper.INSTANCE.toEntity(categorydto);
        this.categoryDao.delete(category);
        return id;
    }
}
