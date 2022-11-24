package com.houser.devtrac_Using_Intellij.Controller;

import com.houser.devtrac_Using_Intellij.Entities.Project;
import com.houser.devtrac_Using_Intellij.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    private ProjectService projectService;
    // display list of projects
    @GetMapping("/list")
    public String viewProjectsList(Model model) {
        model.addAttribute("listProjects", projectService.getAllProjects());
        return "projects/projectslists";
    }

    @GetMapping("/NewProject")
    public String showNewProjectForm(Model model) {
        Project project = new Project(); // create model attribute to bind form data
        model.addAttribute("project", project);
        return "projects/projectsadd";

    }
    @PostMapping("/saveProject")
    public String saveProjectDetails(@ModelAttribute("project") Project project) {
        projectService.saveProject(project); // save project to database
        return "redirect:/projects/list"; //"projectslists";//

    }
    @GetMapping("/ProjectUpdate/{id}")
    public String showProjectUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "projects/projectupdate";

    }
    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable(value = "id") long id) {
        this.projectService.deleteProjectById(id); // call delete project method
        return "redirect:/projects/list";
    }


}
