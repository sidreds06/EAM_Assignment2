package com.library.system.controller;

import com.library.system.model.Publisher;
import com.library.system.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @PostMapping
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher updatedPublisher) {
        return publisherRepository.findById(id).map(publisher -> {
            publisher.setName(updatedPublisher.getName());
            publisher.setAddress(updatedPublisher.getAddress());
            return ResponseEntity.ok(publisherRepository.save(publisher));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Delete publisher
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable Long id) {
        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
            return ResponseEntity.ok("Publisher deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
