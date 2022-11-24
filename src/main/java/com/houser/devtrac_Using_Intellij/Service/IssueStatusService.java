package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.IssueStatus;

import java.util.List;

public interface IssueStatusService {

    List<IssueStatus> getAllIssueStatus();
    void saveIssueStatus(IssueStatus issueStatus);
    IssueStatus getIssueStatusById(long id);
    void deleteIssueStatusById(long id);

}
