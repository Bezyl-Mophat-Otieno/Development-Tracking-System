package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.IssueLog;
import com.houser.devtrac_Using_Intellij.Repository.IssueLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IssueLogServiceImpl implements IssueLogService{

    @Autowired
    private IssueLogRepository issueLogRepository;
    @Override
    public List<IssueLog> getAllIssueLogs() {
        return issueLogRepository.findAll();
    }
    @Override
    public void saveIssueLog(IssueLog issueLog) {
        this.issueLogRepository.save(issueLog);
    }
    @Override
    public IssueLog getIssueLogById(long id) {
        Optional< IssueLog > optional = issueLogRepository.findById(id);
        IssueLog issue = null;
        if (optional.isPresent()) {
            issue = optional.get();
        } else {
            throw new RuntimeException(" IssueLog not found for id :: " + id);
        }
        return issue;
    }
    @Override
    public void deleteIssueLogById(long id) {
        this.issueLogRepository.deleteById(id);
    }

    @Override
    public Object getIssueLogsByIssueID(long issid) {
        return null;
    }

}
