package com.task.service;


import com.task.dto.UserRequest;
import com.task.dto.UserResponse;
 import com.task.entity.User;
 import com.task.exception.ResourceNotFoundException;
 import com.task.repository.TaskRepository;
 import com.task.repository.UserRepository;
 import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserService(UserRepository userRepository,
                       TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    // Create User
    public UserResponse createUser(UserRequest dto) {

        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException(
                    "Email already exists"
            );
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());

        User savedUser = userRepository.save(user);

        return mapToDTO(savedUser);
    }

    // Get All Users
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // Get User By ID
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with ID: " + id
                        ));

        return mapToDTO(user);
    }

    // Update User
    public UserResponse updateUser(
            Long id, UserRequest dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with ID: " + id
                        ));

        boolean emailUsedByAnotherUser =
                userRepository.existsByEmail(dto.email())
                        && !user.getEmail().equalsIgnoreCase(dto.email());

        if (emailUsedByAnotherUser) {
            throw new IllegalArgumentException(
                    "Email already exists"
            );
        }

        user.setName(dto.name());
        user.setEmail(dto.email());

        User updatedUser = userRepository.save(user);

        return mapToDTO(updatedUser);
    }

    // Delete User
    @Transactional
    public String deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with ID: " + id
                        ));

        if (taskRepository.existsByUser_Id(id)) {
            throw new IllegalArgumentException(
                    "Cannot delete user because tasks are assigned to this user"
            );
        }

        userRepository.delete(user);
        return  "User has been deleted";
    }

    // Entity to DTO conversion
    private UserResponse mapToDTO(User user) {

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
