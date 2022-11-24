package com.houser.devtrac_Using_Intellij.Service;

import com.houser.devtrac_Using_Intellij.Entities.IssuePriority;

import java.util.List;

public interface IssuePriorityService {
    List<IssuePriority> getAllIssuePrioritys();
    void saveIssuePriority(IssuePriority issuePriority);
    IssuePriority getIssuePriorityById(long id);
    void deleteIssuePriorityById(long id);
}
