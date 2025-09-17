package com.library.library_application.controller;

import com.library.library_application.service.LoanService;
import com.library.library_application.model.Loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // Issue a new loan (book issued to a member)
    @PostMapping
    public ResponseEntity<Loan> issueLoan(@RequestBody Loan loan) {
        Loan issuedLoan = loanService.issueLoan(loan);
        return new ResponseEntity<>(issuedLoan, HttpStatus.CREATED);
    }

    // Return a book
    @PutMapping("/{id}/return")
    public ResponseEntity<Loan> returnLoan(@PathVariable int id) {
        Loan returnedLoan = loanService.returnLoan(id);
        return ResponseEntity.ok(returnedLoan);
    }

    // Get all loans
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    // Delete a loan record (if needed)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable int id) {
        loanService.deleteLoan(id);
        return ResponseEntity.ok("Loan deleted with id " + id);
    }
}
