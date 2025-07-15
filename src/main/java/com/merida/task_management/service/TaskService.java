package com.merida.task_management.service;

import com.merida.task_management.dto.TaskRequest;
import com.merida.task_management.exception.ResourceNotFoundException;
import com.merida.task_management.model.Remark;
import com.merida.task_management.model.Status;
import com.merida.task_management.model.Task;
import com.merida.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setStatus(Status.PENDING);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    public Task updateTask(Long id, TaskRequest taskRequest) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(taskRequest.getTitle());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setDueDate(taskRequest.getDueDate());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }

    public Task markTaskAsCompleted(Long id) {
        Task task = getTaskById(id);
        if (task.getStatus() == Status.COMPLETED) {
            throw new IllegalStateException("Task is already completed.");
        }
        task.setStatus(Status.COMPLETED);
        task.setCompletionDate(LocalDate.now());

        if (task.getDueDate() != null) {
            if (task.getCompletionDate().isAfter(task.getDueDate())) {
                task.setRemark(Remark.LATE);
            } else {
                task.setRemark(Remark.ON_TIME);
            }
        }
        return taskRepository.save(task);
    }
}
