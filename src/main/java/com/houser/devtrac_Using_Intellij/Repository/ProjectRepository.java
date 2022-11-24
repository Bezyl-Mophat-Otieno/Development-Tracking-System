package com.houser.devtrac_Using_Intellij.Repository;

import com.houser.devtrac_Using_Intellij.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project , Long> {
}
