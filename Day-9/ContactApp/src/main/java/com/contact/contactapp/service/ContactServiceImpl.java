package com.contact.contactapp.service;

import com.contact.contactapp.dto.ContactDTO;
import com.contact.contactapp.entity.Contact;
import com.contact.contactapp.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public ContactDTO createContact(ContactDTO dto) {
        Contact contact = mapToEntity(dto);
        Contact saved = contactRepository.save(contact);
        return mapToDTO(saved);
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        return contactRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDTO getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(this::mapToDTO).orElse(null);
    }

    @Override
    public ContactDTO updateContact(Long id, ContactDTO dto) {
        Optional<Contact> optionalContact = contactRepository.findById(id);

        if (optionalContact.isEmpty()) {
            return null;
        }

        Contact contact = optionalContact.get();
        contact.setName(dto.getName());
        contact.setPhone(dto.getPhone());
        contact.setEmail(dto.getEmail());
        contact.setAddress(dto.getAddress());

        Contact updated = contactRepository.save(contact);
        return mapToDTO(updated);
    }

    @Override
    public boolean deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            return false;
        }
        contactRepository.deleteById(id);
        return true;
    }

    private ContactDTO mapToDTO(Contact contact) {
        return new ContactDTO(
                contact.getId(),
                contact.getName(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getAddress()
        );
    }

    private Contact mapToEntity(ContactDTO dto) {
        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setPhone(dto.getPhone());
        contact.setEmail(dto.getEmail());
        contact.setAddress(dto.getAddress());
        return contact;
    }
}