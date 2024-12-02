// Service-Klasse für Bank-Details
package com.vereinsanmeldung.vereinsanmeldung.Services;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.BankDetailsDto;
import com.vereinsanmeldung.vereinsanmeldung.Entities.BankDetailsEntity;
import com.vereinsanmeldung.vereinsanmeldung.Mapper.BankDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankDetailsService {
    @Autowired
    private BankDetailsMapper bankDetailsMapper;

    public List<BankDetailsDto> getAllBankDetails() {
        return bankDetailsMapper.findAll().stream()
                .map(bankDetailsMapper::bankDetailsEntityToDto)
                .collect(Collectors.toList());
    }

    public BankDetailsDto getBankDetailsById(int bankId) {
        BankDetailsEntity bankDetailsEntity = bankDetailsMapper.readBankDetailsById(bankId);
        return bankDetailsEntity != null ? bankDetailsMapper.bankDetailsEntityToDto(bankDetailsEntity) : null;
    }

    // Insert (Create) operation
    public BankDetailsDto createBankDetails(BankDetailsDto bankDetailsDto) {
        BankDetailsEntity bankDetailsEntity = bankDetailsMapper.bankDetailsDtoToEntity(bankDetailsDto);
        bankDetailsMapper.insertBankDetails(bankDetailsEntity);
        return bankDetailsMapper.bankDetailsEntityToDto(bankDetailsEntity);
    }

    // Update operation (all data except ID)
    public BankDetailsDto updateBankDetails(int bankId, BankDetailsDto bankDetailsDto) {
        BankDetailsEntity bankDetailsEntity = bankDetailsMapper.bankDetailsDtoToEntity(bankDetailsDto);
        bankDetailsEntity.setBankId(bankId); // Make sure the ID remains the same
        bankDetailsMapper.updateBankDetails(bankDetailsEntity);
        return bankDetailsMapper.bankDetailsEntityToDto(bankDetailsEntity);
    }

    // Delete operation by bank ID
    public void deleteBankDetails(int bankId) {
        bankDetailsMapper.deleteBankDetails(bankId);
    }

    // Delete operation by user ID (neue Methode)
    public void deleteBankDetailsByUserId(int userId) {
        bankDetailsMapper.deleteBankDetailsByUserId(userId);
    }
}
