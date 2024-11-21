// Controller-Klasse für User-Endpoints
package com.vereinsanmeldung.vereinsanmeldung.Controller;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.UserDto;
import com.vereinsanmeldung.vereinsanmeldung.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    // Insert (Create) operation
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    // Update operation (all data except ID)
    @PutMapping("/{userId}")
    public UserDto updateUser(@PathVariable int userId, @RequestBody UserDto userDto) {
        return userService.updateUser(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
