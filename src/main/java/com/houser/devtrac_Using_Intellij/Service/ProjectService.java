package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.Project;

import java.util.List;

public interface ProjectService {
    List< Project > getAllProjects();
    void saveProject(Project project);
    Project getProjectById(long id);
    void deleteProjectById(long id);
}
