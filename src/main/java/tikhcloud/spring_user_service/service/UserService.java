package tikhcloud.spring_user_service.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tikhcloud.spring_user_service.dto.RegistrationDto;
import tikhcloud.spring_user_service.model.User;
import tikhcloud.spring_user_service.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registration(RegistrationDto registrationDto) {
        User user = new User();
        user.setUserName(registrationDto.getUsername());
        user.setUserSurname(registrationDto.getSurname());
        user.setBirthDate(registrationDto.getDateOfBirth());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User findUser(String email) throws Exception {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new Exception("User with email " + email + ", not found"));
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
