package day1.usercrudapi.controller;

import day1.usercrudapi.entity.User;
import day1.usercrudapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("/login/{id}")
    public void login(@PathVariable Long id){
        userService.getUser(id);
    }

    @PatchMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
