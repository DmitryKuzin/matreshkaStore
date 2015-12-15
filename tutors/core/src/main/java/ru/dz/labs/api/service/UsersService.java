package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.repository.UsersRepository;

import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public void addUser(Users user){ usersRepository.addUser(user);}

    public List<Users> getAllUsers(){
        return usersRepository.getAllUsers();
    }

    public void updateUsers(Users user) {
        usersRepository.updateUsers(user);
    }

    public Users getUserById(Long id) {
        return usersRepository.getUserById(id);
    }

    public void deleteUser(Users user) {
        usersRepository.deleteUser(user);
    }

}
