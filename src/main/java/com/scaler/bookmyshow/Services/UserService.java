package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Exceptions.UserNotFoundException;
import com.scaler.bookmyshow.Models.User;
import com.scaler.bookmyshow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(String email , String password ){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }

        //sign up
        User user = new User();
        user.setEmail(email);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        userRepository.save(user);
        return user;
    }

    public User login ( String email , String password) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if ( optionalUser.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        User user = optionalUser.get();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if ( bCryptPasswordEncoder.matches(password,user.getPassword())){
            return user;
        }
        return null;
    }
}
