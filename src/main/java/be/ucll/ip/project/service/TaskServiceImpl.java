package be.ucll.ip.project.service;


import be.ucll.ip.project.domain.SubTask;
import be.ucll.ip.project.domain.Task;
import be.ucll.ip.project.dto.SubTaskDTO;
import be.ucll.ip.project.dto.TaskDTO;
import be.ucll.ip.project.repository.SubtaskRepository;
import be.ucll.ip.project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepo;
    private final SubtaskRepository subtaskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepo, SubtaskRepository subtaskRepository){
        this.taskRepo = taskRepo;
        this.subtaskRepository = subtaskRepository;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    @Override
    public TaskDTO getTask(Integer id) {
            Task task = taskRepo.findById(id).get();
            TaskDTO taskDTO = TaskDTO.taskToTaskDto(task);
            return  taskDTO;
    }

    @Override
    public void addTask(TaskDTO taskdto) {
        Task task = new Task();
        task.setTime(taskdto.getTime());
        task.setId(taskdto.getId());
        task.setDescription(taskdto.getDescription());
        task.setTitle(taskdto.getTitle());
        taskRepo.save(task);
    }

    @Override
    public void editTask(TaskDTO taskDTO) {
        TaskDTO t = getTask(taskDTO.getId());
        t.setTime(taskDTO.getTime());
        t.setDescription(taskDTO.getDescription());
        t.setTitle(taskDTO.getTitle());
        addTask(t);
    }

    @Override
    public Integer getNextId() {
        if(taskRepo.findAll().size()==0){
            return 1;
        }else{
            int i = taskRepo.findAll().size() + 1;

            return i;
        }

    }



    @Override
    public void addSubTask(String id, SubTaskDTO subtaskdto) {
        Task t = taskRepo.findById(Integer.valueOf(id)).get();
        SubTask subTask = SubTaskDTO.dtoToSubTask(subtaskdto);
        subtaskRepository.save(subTask);
        t.addSubtask(subTask);
        taskRepo.save(t);
    }
}
