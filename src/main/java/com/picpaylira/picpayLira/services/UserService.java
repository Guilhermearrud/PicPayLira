package com.picpaylira.picpayLira.services;

import com.picpaylira.picpayLira.domain.user.User;
import com.picpaylira.picpayLira.domain.user.UserType;
import com.picpaylira.picpayLira.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service // Indicate to spring framework that this is a class service so it can inject all the dependencies correctly.
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("User of type Merchant is not allowed to do this transaction.");
        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("User doesn't have enough balance to do this transaction");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
