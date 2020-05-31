package be.ucll.ip.project.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Task{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotEmpty
    private String title;
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;

    @OneToMany
    private List<SubTask> subtasks;

    public Task(String title, String description, LocalDateTime time, int id){
        setTitle(title);
        setDescription(description);
        setTime(time);
        setId(id);
        subtasks = new ArrayList<>();
    }

    public Task(){
        subtasks = new ArrayList<>();
    }


    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getTime(){
        return time;
    }

    public void setTime(LocalDateTime time){
        this.time = time;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public List<SubTask> getSubtasks(){
        return subtasks;
    }
    public void addSubtask(SubTask subTask){
        subtasks.add(subTask);
    }


}
