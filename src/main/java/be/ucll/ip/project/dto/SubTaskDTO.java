package be.ucll.ip.project.dto;

import be.ucll.ip.project.domain.SubTask;

public class SubTaskDTO {
    private int id;

    private String title;
    private String description;

    public SubTaskDTO(String title, String description){
        setTitle(title);
        setDescription(description);
    }

    public static SubTask dtoToSubTask(SubTaskDTO subTaskDTO){
        return new SubTask(subTaskDTO.getTitle(), subTaskDTO.getDescription());
    }

    public int getId(){
        return id;
    }

    public void setId( int id){
        this.id=id;
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
}
