package com.mpokket.textsearch.service;

import com.mpokket.textsearch.entity.Document;

import java.util.List;

public interface DocumentService {

    List<Document> searchDocuments(String query);

    Document addDoc(Document doc);
}
