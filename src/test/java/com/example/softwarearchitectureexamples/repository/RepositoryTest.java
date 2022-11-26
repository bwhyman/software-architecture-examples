package com.example.softwarearchitectureexamples.repository;

import com.example.softwarearchitectureexamples.dto.Address;
import com.example.softwarearchitectureexamples.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void addAdminTest() {
        User u = User.builder()
                .account("admin")
                .password("1001")
                .role(User.ADMIN)
                .build();
        userRepository.save(u);
    }

    @Test
    public void addUserTest() {
        User u = User.builder()
                .account("1001")
                .password("1001")
                .role(User.USER)
                .build();
        userRepository.save(u);
    }

    @Test
    public void findUserByIdTest() {
        userRepository.findById(1).ifPresent(System.out::println);
    }

    @Test
    public void findUserTest() {
        User u = userRepository.find("admin", "1001");
        log.debug("{}", u);
    }

    @Test
    public void addAddressTest() {
        Address a = Address.builder()
                .detail("491")
                .userId(2)
                .build();
        addressRepository.save(a);
        Address a2 = Address.builder()
                .detail("237")
                .userId(2)
                .build();
        addressRepository.save(a2);
    }

    @Test
    public void findAddressesTest() {
        addressRepository.findAddresses(4).forEach(System.out::println);
    }

    @Test
    public void findUserByAddressTest() {
        User u = userRepository.find(1);
        log.debug("{}", u);
    }
}
