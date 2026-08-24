package com.fundoo.fundooapp.specification;

import com.fundoo.fundooapp.entity.Note;
import com.fundoo.fundooapp.entity.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class NoteSpecification {

    public static Specification<Note> search(User owner, String titleText, String state, String labelName) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.equal(root.get("owner"), owner)); // ALWAYS applied, unconditionally

            if (titleText != null && !titleText.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + titleText.toLowerCase() + "%"));
            }

            if (state != null && !state.isBlank()) {
                switch (state.toUpperCase()) {
                    case "PINNED" -> predicates.add(cb.isTrue(root.get("isPined")));
                    case "ARCHIVED" -> predicates.add(cb.isTrue(root.get("isArchived")));
                    case "TRASHED" -> predicates.add(cb.isTrue(root.get("isDeleted")));
                    case "ACTIVE" -> predicates.add(cb.isFalse(root.get("isDeleted")));
                    default -> { /* unrecognized state -- ignore filter, don't throw */ }
                }
            }

            if (labelName != null && !labelName.isBlank()) {
                predicates.add(cb.equal(root.join("labels").get("label"), labelName));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}