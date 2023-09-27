package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.Contactdto;

import java.util.List;

public interface IContactService {

    Contactdto queryContact (Contactdto contactdto);
    List<Contactdto> queryAllContacts();

    int insertContact (Contactdto contactdto);
    int updateContact (Contactdto contactdto);

    int deleteContact (Contactdto contactdto);
}
