package com.mpokket.textsearch.service;

import com.mpokket.textsearch.entity.Document;
import com.mpokket.textsearch.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    @Override
    @Cacheable("searchResults")
    public List<Document> searchDocuments(String query){
        List<Document> searchResults = documentRepository.findByKeyword(query);
        return searchResults;
    }

    @Override
    @CacheEvict("searchResults")
    public Document addDoc(Document doc){
        Document savedDoc = documentRepository.save(doc);
        return savedDoc;
    }


}
