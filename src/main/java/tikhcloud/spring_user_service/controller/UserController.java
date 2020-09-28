package tikhcloud.spring_user_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tikhcloud.spring_user_service.dto.DeleteDto;
import tikhcloud.spring_user_service.dto.RegistrationDto;
import tikhcloud.spring_user_service.model.User;
import tikhcloud.spring_user_service.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDto registrationDto) {
        userService.registration(registrationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteDto deleteDto) {
        userService.deleteUser(deleteDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("find")
    public User find(@RequestBody String email) throws Exception {
        return userService.findUser(email);
    }
}
