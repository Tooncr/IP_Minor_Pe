package be.ucll.ip.project.service;

import be.ucll.ip.project.domain.Task;
import be.ucll.ip.project.dto.SubTaskDTO;
import be.ucll.ip.project.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    public List<Task> getTasks();
    public TaskDTO getTask(Integer id);

    void addTask(TaskDTO task);
    public Integer getNextId();

    void editTask(TaskDTO taskDTO);


    void addSubTask(String id, SubTaskDTO subtask);
}
