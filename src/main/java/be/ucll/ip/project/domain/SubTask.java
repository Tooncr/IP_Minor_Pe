package be.ucll.ip.project.domain;

import javax.persistence.*;

@Entity
public class SubTask {

    @Id
    @GeneratedValue
    private int id;


    private String title;

    private String description;

    public SubTask(){

    }

    public SubTask(String title, String description){
        setTitle(title);
        setDescription(description);
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
