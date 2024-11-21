// Controller-Klasse für BankDetails-Endpoints
package com.vereinsanmeldung.vereinsanmeldung.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.BankDetailsDto;
import com.vereinsanmeldung.vereinsanmeldung.Services.BankDetailsService;

@RestController
@RequestMapping("/api/bank-details")
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @GetMapping
    public List<BankDetailsDto> getAllBankDetails() {
        return bankDetailsService.getAllBankDetails();
    }

    @GetMapping("/{bankId}")
    public BankDetailsDto getBankDetailsById(@PathVariable int bankId) {
        return bankDetailsService.getBankDetailsById(bankId);
    }

    // Insert (Create) operation
    @PostMapping
    public BankDetailsDto createBankDetails(@RequestBody BankDetailsDto bankDetailsDto) {
        return bankDetailsService.createBankDetails(bankDetailsDto);
    }

    // Update operation (all data except ID)
    @PutMapping("/{bankId}")
    public BankDetailsDto updateBankDetails(@PathVariable int bankId, @RequestBody BankDetailsDto bankDetailsDto) {
        return bankDetailsService.updateBankDetails(bankId, bankDetailsDto);
    }

    @DeleteMapping("/{bankId}")
    public void deleteBankDetails(@PathVariable int bankId) {
        bankDetailsService.deleteBankDetails(bankId);
    }
}
