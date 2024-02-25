package com.renegz.contentcalendar.repository;

import com.renegz.contentcalendar.model.Content;
import com.renegz.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {

    List<Content> findAllByTitleContains(String keyword); //Manera 1 (Query derivation)

    @Query("""
        SELECT * FROM Content
        WHERE status = :status
    """)
    List<Content> listByStatus(@Param("status") Status status); //Manera 2 (Custom Query)

}
