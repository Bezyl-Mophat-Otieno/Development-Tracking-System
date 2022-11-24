package com.houser.devtrac_Using_Intellij.Repository;

import com.houser.devtrac_Using_Intellij.Entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
    List<Issue> findByProjectID(long projectID);
}
