package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.Issue;
import com.houser.devtrac_Using_Intellij.Entities.IssuePriority;
import com.houser.devtrac_Using_Intellij.Repository.IssuePriorityRepository;
import com.houser.devtrac_Using_Intellij.Repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IssuePriorityServiceImpl implements  IssuePriorityService{
    @Autowired
    private IssuePriorityRepository issuePriorityRepository;
    @Override
    public List <IssuePriority> getAllIssuePrioritys() {
        return issuePriorityRepository.findAll();
    }

    @Override
    public void saveIssuePriority(IssuePriority issuePriority) {
        this.issuePriorityRepository.save(issuePriority);


    }

    @Override
    public IssuePriority getIssuePriorityById(long id) {
        Optional < IssuePriority > optional = issuePriorityRepository.findById(id);
        IssuePriority issue = null;
        if (optional.isPresent()) {
            issue = optional.get();
        } else {
            throw new RuntimeException(" IssueStatus not found for id :: " + id);
        }
        return issue;
    }
    @Override
    public void deleteIssuePriorityById(long id) {
        this.issuePriorityRepository.deleteById(id);
    }

}
