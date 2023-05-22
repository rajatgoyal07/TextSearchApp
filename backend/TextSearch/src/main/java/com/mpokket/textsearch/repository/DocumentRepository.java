package com.mpokket.textsearch.repository;

import com.mpokket.textsearch.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("Select d from Document d where LOWER(d.title) LIKE %:query% OR LOWER(d.description) LIKE %:query%")
    List<Document> findByKeyword(String query);
}
