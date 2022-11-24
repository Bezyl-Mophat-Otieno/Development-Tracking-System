package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.IssueLog;

import java.util.List;

public interface IssueLogService {
    List<IssueLog> getAllIssueLogs();
    void saveIssueLog(IssueLog issueLog);
    IssueLog getIssueLogById(long id);
    void deleteIssueLogById(long id);

    Object getIssueLogsByIssueID(long issid);
}
