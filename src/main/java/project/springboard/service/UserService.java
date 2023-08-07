package project.springboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.springboard.dto.UserDto;
import project.springboard.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Transactional
    public boolean existsByUserId(String userId){
        return userRepository.existsByUserId(userId);
    }

    @Transactional
    public void save(UserDto userDto){
        userRepository.save(userDto.toEntity());
    }





}
