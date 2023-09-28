package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.Contact;
import com.campusdual.appmazing.model.dao.ContactDao;
import com.campusdual.appmazing.model.dto.Contactdto;
import com.campusdual.appmazing.model.dto.dtomapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ContactService")
@Lazy
public class ContactService implements IContactService {
    @Autowired
    private ContactDao contactDao;
    @Override
    public Contactdto queryContact(Contactdto contactdto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactdto);
        Contact contactFinal = this.contactDao.getReferenceById(contact.getId());
        return ContactMapper.INSTANCE.toDTO(contactFinal);
    }

    @Override
    public List<Contactdto> queryAllContacts() {
        return ContactMapper.INSTANCE.toDTOList(this.contactDao.findAll());
    }

    @Override
    public int insertContact(Contactdto contactdto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactdto);
        this.contactDao.saveAndFlush(contact);
        return contact.getId();

    }

    @Override
    public int updateContact(Contactdto contactdto) {
        return this.insertContact(contactdto);
    }

    @Override
    public int deleteContact(Contactdto contactdto) {
        int id = contactdto.getId();
        Contact contact = ContactMapper.INSTANCE.toEntity(contactdto);
        this.contactDao.delete(contact);
        return id;

    }
}
