package by.itstep.service.impl;

import by.itstep.dto.UserDto;
import by.itstep.models.Role;
import by.itstep.models.Roles;
import by.itstep.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import by.itstep.repository.UserRepository;
import by.itstep.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public boolean saveDto(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());
        userRepository.save(user);
        return true;
    }
    @Override
    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      User user = userRepository.findFirstByUserName(userName);
      if (user == null){
          throw  new UsernameNotFoundException("User not found with name : " + userName);
      }
      List<GrantedAuthority> roles = new ArrayList<>();
      roles.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));

      return new org.springframework.security.core.userdetails.User(
              user.getUserName(),
              user.getPassword(),
              roles
      );
    }
}
