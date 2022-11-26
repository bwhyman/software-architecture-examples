package com.example.softwarearchitectureexamples.service;

import com.example.softwarearchitectureexamples.dto.Address;
import com.example.softwarearchitectureexamples.dto.User;
import com.example.softwarearchitectureexamples.repository.AddressRepository;
import com.example.softwarearchitectureexamples.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }


    public User getUser(int uid) {
        return userRepository.findById(uid).orElse(null);
    }

    @Transactional
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public User getUser(String account, String password) {
        return userRepository.find(account, password);
    }

    public List<Address> listAddresses(int uid) {
        return addressRepository.findAddresses(uid);
    }
}
