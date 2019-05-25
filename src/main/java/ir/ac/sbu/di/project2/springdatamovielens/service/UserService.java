package ir.ac.sbu.di.project2.springdatamovielens.service;

import ir.ac.sbu.di.project2.springdatamovielens.model.User;
import ir.ac.sbu.di.project2.springdatamovielens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void create(User user) {
        if (userRepository.find(user.getUsername()) == null)
            userRepository.save(user);
        else System.out.println("User Exists.");
    }

    public User find(String username) {
        return userRepository.find(username);
    }


    public User findSimilarUser(String username) {
        return userRepository.findSimilarUser(username);
    }
}
