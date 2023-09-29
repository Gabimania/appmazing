package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.Categorydto;
import com.campusdual.appmazing.model.dto.Contactdto;

import java.util.List;

public interface ICategoryService {
    Categorydto queryCategory (Categorydto categorydto);
    List<Categorydto> queryAllCategories();

    int insertCategory (Categorydto categorydto);
    int updateCategory (Categorydto categorydto);

    int deleteCategory (Categorydto categorydto);
}
