package be.ucll.ip.project.dto;

import be.ucll.ip.project.domain.SubTask;
import be.ucll.ip.project.domain.Task;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

public class TaskDTO {
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private int id;

    private List<SubTask> subtasks;

    public TaskDTO(String title, String description, LocalDateTime time, List<SubTask> subtasks, int id){
        setTitle(title);
        setTime(time);
        setDescription(description);
        setId(id);
        this.subtasks = subtasks;
    }

    public TaskDTO() {

    }

    public static Task DtoToTask(TaskDTO taskDTO){
        return new Task(taskDTO.title, taskDTO.description, taskDTO.time, taskDTO.id);
    }
    public static TaskDTO taskToTaskDto(Task task){
        return new TaskDTO(task.getTitle(), task.getDescription(), task.getTime(),task.getSubtasks(), task.getId());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<SubTask> getSubtasks(){
        return subtasks;
    }

    public void setSubtasks(List<SubTask> subtasks){
        this.subtasks = subtasks;
    }

}
