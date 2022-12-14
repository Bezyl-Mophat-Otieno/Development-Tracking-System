package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.Issue;
import com.houser.devtrac_Using_Intellij.Repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IssueServiceImpl implements IssueService{
    @Autowired
    private IssueRepository issueRepository;
    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
    @Override
    public List < Issue > getIssuesByProjectID(long projectID) {
        return issueRepository.findByProjectID(projectID);
    }
    @Override
    public void saveIssue(Issue issue) {
        this.issueRepository.save(issue);
    }
    @Override
    public Issue getIssueById(long id) {
        Optional< Issue > optional = issueRepository.findById(id);
        Issue issue = null;
        if (optional.isPresent()) {
            issue = optional.get();
        } else {
            throw new RuntimeException(" Issue not found for id :: " + id);
        }
        return issue;
    }
    @Override
    public void deleteIssueById(long id) {
        this.issueRepository.deleteById(id);
    }

}
