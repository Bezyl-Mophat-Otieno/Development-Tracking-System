package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.Issue;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IssueService {

    List<Issue> getAllIssues();
    void saveIssue(Issue issue);
    Issue getIssueById(long id);
    void deleteIssueById(long id);

    Object getIssuesByProjectID(long projectid);
}
