package com.mpokket.textsearch.controller;

import com.mpokket.textsearch.entity.Document;
import com.mpokket.textsearch.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    private final DocumentService documentService;

    public SearchController(DocumentService documentService){
        this.documentService = documentService;
    }

    @GetMapping("/search")
    public List<Document> searchDos(@RequestParam("q") String q){
        return documentService.searchDocuments(q);
    }

    @PostMapping("/add/documents")
    public Document addDoc(@RequestBody Document doc){
        return documentService.addDoc(doc);
    }
}
