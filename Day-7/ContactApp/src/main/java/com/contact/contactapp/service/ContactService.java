package com.contact.contactapp.service;


import com.contact.contactapp.dto.ContactDTO;
import java.util.List;

public interface ContactService {
    ContactDTO createContact(ContactDTO contactDTO);
    List<ContactDTO> getAllContacts();
    ContactDTO getContactById(Long id);
    ContactDTO updateContact(Long id, ContactDTO contactDTO);
    boolean deleteContact(Long id);
}