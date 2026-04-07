package day1.usercrudapi.service;

import day1.usercrudapi.entity.User;
import day1.usercrudapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, User user){
        User updatedUser = user.builder()
                .id(id)
                .name(user.getName())
                .email(user.email)
                .password(user.getPassword())
                .build();
        userRepository.save(updatedUser);
    }
}
