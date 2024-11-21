// Controller-Klasse für AdditionalUser-Endpoints
package com.vereinsanmeldung.vereinsanmeldung.Controller;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.AdditionalUserDto;
import com.vereinsanmeldung.vereinsanmeldung.Services.AdditionalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/additional-users")
public class AdditionalUserController {

    @Autowired
    private AdditionalUserService additionalUserService;

    @GetMapping
    public List<AdditionalUserDto> getAllAdditionalUsers() {
        return additionalUserService.getAllAdditionalUsers();
    }

    @GetMapping("/{additionalUserId}")
    public AdditionalUserDto getAdditionalUserById(@PathVariable int additionalUserId) {
        return additionalUserService.getAdditionalUserById(additionalUserId);
    }

    // Insert (Create) operation
    @PostMapping
    public AdditionalUserDto createAdditionalUser(@RequestBody AdditionalUserDto additionalUserDto) {
        return additionalUserService.createAdditionalUser(additionalUserDto);
    }

    // Update operation (all data except ID)
    @PutMapping("/{additionalUserId}")
    public AdditionalUserDto updateAdditionalUser(@PathVariable int additionalUserId, @RequestBody AdditionalUserDto additionalUserDto) {
        return additionalUserService.updateAdditionalUser(additionalUserId, additionalUserDto);
    }

    @DeleteMapping("/{additionalUserId}")
    public void deleteAdditionalUser(@PathVariable int additionalUserId) {
        additionalUserService.deleteAdditionalUser(additionalUserId);
    }
}
