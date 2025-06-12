package com.library.system.controller;

import com.library.system.model.Borrow;
import com.library.system.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowRepository borrowRepository;

    @PostMapping
    public Borrow addBorrow(@RequestBody Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    @GetMapping
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
        return borrowRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 // PUT: Update borrow record
    @PutMapping("/{id}")
    public ResponseEntity<Borrow> updateBorrow(@PathVariable Long id, @RequestBody Borrow updatedBorrow) {
        return borrowRepository.findById(id).map(borrow -> {
            borrow.setIssue(updatedBorrow.getIssue());
            borrow.setDueDate(updatedBorrow.getDueDate());
            borrow.setReturnDate(updatedBorrow.getReturnDate());
            borrow.setBook(updatedBorrow.getBook());
            borrow.setMember(updatedBorrow.getMember());
            return ResponseEntity.ok(borrowRepository.save(borrow));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Delete borrow record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBorrow(@PathVariable Long id) {
        if (borrowRepository.existsById(id)) {
            borrowRepository.deleteById(id);
            return ResponseEntity.ok("Borrow record deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
