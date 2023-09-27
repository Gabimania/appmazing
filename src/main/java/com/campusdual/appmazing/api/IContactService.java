package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.Contactdto;

import java.util.List;

public interface IContactService {

    Contactdto queryContact (Contactdto contact);
    List<Contactdto> queryAllContacts();

    int insertContact (Contactdto contact);
    int updateContact (Contactdto contact);

    int deleteContact (Contactdto contact);
}
