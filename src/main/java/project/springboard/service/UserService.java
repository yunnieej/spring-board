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
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public boolean existsByUserId(String userId){
        return userRepository.existsByUserId(userId);
    }

    public void save(UserDto userDto){
        userRepository.save(userDto.toEntity());
    }

    public boolean login(String userId, String userPassword){
        User byUserId = userRepository.findByUserId(userId);
        if(byUserId == null){
            return false;
        }else{
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
