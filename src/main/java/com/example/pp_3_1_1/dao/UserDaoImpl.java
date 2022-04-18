package com.example.pp_3_1_1.dao;

import com.example.pp_3_1_1.model.User;
import com.example.pp_3_1_1.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

//    @PersistenceContext
    private final UserRepository userRepository;
    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        Optional<User> result = userRepository.findById(id);
        return result.orElseGet(result::get);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void removeUserById(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
