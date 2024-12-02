// AdminController für die Verwaltung von Benutzerinformationen
package com.vereinsanmeldung.vereinsanmeldung.Controller;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.UserDto;
import com.vereinsanmeldung.vereinsanmeldung.Dtos.AdditionalUserDto;
import com.vereinsanmeldung.vereinsanmeldung.Services.UserService;
import com.vereinsanmeldung.vereinsanmeldung.Services.AdditionalUserService;
import com.vereinsanmeldung.vereinsanmeldung.Services.BankDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anmeldung/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdditionalUserService additionalUserService;

    @Autowired
    private BankDetailsService bankDetailsService;

    // Login-Seite für Administratoren
    @GetMapping("/login")
    public String login() {
        return "Login Page";  // Diese Methode sollte die Login-Seite rendern
    }

    // Seite für Benutzerverwaltung - Nutzer und zusätzliche Nutzer anzeigen
    @GetMapping("/user")
    public List<UserDto> getAllUsersWithAdditionalUsers() {
        List<UserDto> users = userService.getAllUsers();
        for (UserDto user : users) {
            List<AdditionalUserDto> additionalUsers = additionalUserService.getAdditionalUsersByUserId(user.userId());
            user = user.withAdditionalUserDtos(additionalUsers);
        }
        return users;
    }

    // Benutzerinformationen, zusätzliche Nutzer und Bankdetails aktualisieren
    @PutMapping("/user/{userId}")
    public UserDto updateUserWithDetails(@PathVariable int userId, @RequestBody UserDto userDto) {
        userService.updateUser(userId, userDto);

        if (userDto.getAdditionalUserDtos() != null) {
            for (AdditionalUserDto additionalUser : userDto.getAdditionalUserDtos()) {
                additionalUserService.updateAdditionalUser(additionalUser.additionalUserId(), additionalUser);
            }
        }

        if (userDto.getBankDetailsDto() != null) {
            bankDetailsService.updateBankDetails(userDto.getBankDetailsDto().bankId(), userDto.getBankDetailsDto());
        }

        return userService.getUserById(userId);
    }

    // Benutzerinformationen löschen (einschließlich zusätzliche Nutzer und Bankdaten)
    @DeleteMapping("/user/{userId}")
    public void deleteUserWithDetails(@PathVariable int userId) {
        List<AdditionalUserDto> additionalUsers = additionalUserService.getAdditionalUsersByUserId(userId);
        for (AdditionalUserDto additionalUser : additionalUsers) {
            additionalUserService.deleteAdditionalUser(additionalUser.additionalUserId());
        }
        bankDetailsService.deleteBankDetailsByUserId(userId);
        userService.deleteUser(userId);
    }

    // Registrierungsseite für Nutzer - Neue Nutzer anlegen
    @PostMapping("/registration")
    public String registerUser(@RequestBody UserDto userDto) {
        userDto = userDto.withConfirmation(false); // Setze Bestätigung standardmäßig auf false
        UserDto createdUser = userService.createUser(userDto);

        if (userDto.getAdditionalUserDtos() != null) {
            for (AdditionalUserDto additionalUser : userDto.getAdditionalUserDtos()) {
                AdditionalUserDto userWithId = additionalUser.withUserId(createdUser.userId());
                additionalUserService.createAdditionalUser(userWithId);
            }
        }

        if (userDto.getBankDetailsDto() != null) {
            bankDetailsService.createBankDetails(userDto.getBankDetailsDto().withUserId(createdUser.userId()));
        }

        return "User registered successfully";
    }
}
