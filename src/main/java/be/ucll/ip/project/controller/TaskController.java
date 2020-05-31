package be.ucll.ip.project.controller;

import be.ucll.ip.project.dto.SubTaskDTO;
import be.ucll.ip.project.dto.TaskDTO;
import be.ucll.ip.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        model.addAttribute("nextid", taskService.getNextId());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") String id){
        TaskDTO taskdto = taskService.getTask(Integer.valueOf(id));
        model.addAttribute("task", taskdto);
        model.addAttribute("subtasks", taskdto.getSubtasks());
        return "task";
    }

    @GetMapping("/new")
    public String addTaskPage(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("nextid", taskService.getNextId());
        return "newTask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "tasks";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(Model model, @PathVariable("id") String id){
        TaskDTO task = taskService.getTask(Integer.valueOf(id));
        model.addAttribute("task", task);
        return "editTask";
    }

    @PostMapping("/tasks/edit/{id}")
    public String editTaskPost(@PathVariable("id") String id, @ModelAttribute TaskDTO taskDTO){
        taskService.editTask(taskDTO);
        return "redirect:/tasks/" + id;
    }

    @GetMapping("/tasks/{id}/sub/createtask")
    public String addsubTask(@PathVariable("id") String id, Model model){
        TaskDTO taskDTO = taskService.getTask(Integer.valueOf(id));
        model.addAttribute("task",taskDTO);
        return "newSubTask";
    }

    @PostMapping("/addSubTask")
    public String addSubTaskPost(@RequestParam(value = "id") String id, @ModelAttribute SubTaskDTO subTask){
        taskService.addSubTask(id,subTask);
        return "redirect:/tasks/" +id;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
