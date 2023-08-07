package project.springboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.springboard.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;



}
