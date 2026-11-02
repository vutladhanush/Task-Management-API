package com.task.service;

import com.task.dto.TaskRequest;
import com.task.dto.TaskResponse;
import com.task.dto.TaskStatus;
import com.task.entity.Task;
import com.task.entity.User;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.TaskRepository;
import com.task.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,
                       UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // Create Task
    public TaskResponse createTask(TaskRequest dto) {

        User user = getUser(dto.userId());

        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());
        task.setDueDate(dto.dueDate());
        task.setUser(user);

        Task savedTask = taskRepository.save(task);

        return mapToDTO(savedTask);
    }

    // Get All Tasks
    @Transactional(readOnly = true)
    public List<TaskResponse> getAllTasks() {

        return taskRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // Get Task By ID
    @Transactional(readOnly = true)
    public TaskResponse getTaskById(Long id) {

        Task task = getTask(id);

        return mapToDTO(task);
    }

    // Get Tasks By User
    @Transactional(readOnly = true)
    public List<TaskResponse> getTasksByUser(Long userId) {

        getUser(userId);

        return taskRepository.findByUser_Id(userId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // Update Task
    public TaskResponse updateTask(
            Long id, TaskRequest dto) {

        Task task = getTask(id);

        User user = getUser(dto.userId());

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());
        task.setDueDate(dto.dueDate());
        task.setUser(user);

        Task updatedTask = taskRepository.save(task);

        return mapToDTO(updatedTask);
    }

    // Update Only Task Status
    public TaskResponse updateTaskStatus(
            Long id,
             TaskStatus dto) {

        Task task = getTask(id);

        task.setStatus(dto.status());

        Task updatedTask = taskRepository.save(task);

        return mapToDTO(updatedTask);
    }

    // Delete Task
    public String deleteTask(Long id) {

        Task task = getTask(id);

        taskRepository.delete(task);
        return  "Task has been deleted";
    }

    // Find User
    private User getUser(Long userId) {

        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with ID: " + userId
                        ));
    }

    // Find Task
    private Task getTask(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task not found with ID: " + id
                        ));
    }

    // Entity to DTO conversion
    private TaskResponse mapToDTO(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getDueDate(),
                task.getUser().getId(),
                task.getUser().getName()
        );
    }
}
