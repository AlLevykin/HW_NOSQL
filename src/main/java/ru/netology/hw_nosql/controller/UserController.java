package ru.netology.hw_nosql.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import ru.netology.hw_nosql.model.User;
import ru.netology.hw_nosql.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody @Validated User user) {
        return userService.saveUser(user);
    }

    @PatchMapping
    public User updateUser(@RequestBody @Validated User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<String> handlerMethodValidationExceptionHandler(HandlerMethodValidationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getReason());
    }
}
