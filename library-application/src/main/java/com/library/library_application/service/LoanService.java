package com.library.library_application.service;

import com.library.library_application.model.Loan;
import com.library.library_application.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    //constructor dependency injection
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    public Loan issueLoan(Loan loan) {
        return loanRepository.save(loan);
    }


    public Loan returnLoan(int id) {
        Optional<Loan> loanOpt = loanRepository.findById(id);
        if (loanOpt.isPresent()) {
            Loan loan = loanOpt.get();
            return loanRepository.save(loan);
        } else {
            throw new RuntimeException("Loan not found with id " + id);
        }
    }


    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }


    public Optional<Loan> getLoanById(int id) {
        return loanRepository.findById(id);
    }


    public void deleteLoan(int id) {
        loanRepository.deleteById(id);
    }
}
