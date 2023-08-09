package project.springboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.springboard.dto.UserDto;
import project.springboard.entity.User;
import project.springboard.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public boolean existsByUserId(String userId){
        return userRepository.existsByUserId(userId);
    }

    @Transactional
    public void save(UserDto userDto){
        userRepository.save(userDto.toEntity());
    }

    @Transactional
    public boolean login(String userId, String userPassword){
        if(userRepository.existsByUserId(userId) == false){
            return false;
        }else{
            User byUserId = userRepository.findByUserId(userId);
//            System.out.println("1:"+byUserId.getUserPassword().getClass().getName());
//            System.out.println("2:"+userPassword.getClass().getName());
            if(byUserId.getUserPassword().equals(userPassword)){
                return true;
            }else{
                return false;
            }
        }
    }




}
