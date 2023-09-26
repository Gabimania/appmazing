package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Contact;
import com.campusdual.appmazing.model.dto.Contactdto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    Contactdto toDTO(Contact contact);
    List<Contactdto> toDTOList(List<Contact> contacts);
    Contact toEntity(Contactdto contactdto);
}
