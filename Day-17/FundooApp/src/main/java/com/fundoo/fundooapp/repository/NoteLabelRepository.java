package com.fundoo.fundooapp.repository;

import com.fundoo.fundooapp.entity.NoteLabel;
import com.fundoo.fundooapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteLabelRepository extends JpaRepository<NoteLabel, Integer> {
    List<NoteLabel> findByOwnerAndIsDeletedFalse(User owner);
    Optional<NoteLabel> findByIdAndOwner(int id, User owner);
    boolean existsByLabelAndOwnerAndIsDeletedFalse(String label, User owner);
}