package com.houser.devtrac_Using_Intellij.Controller;

import com.houser.devtrac_Using_Intellij.Entities.Issue;
import com.houser.devtrac_Using_Intellij.Entities.IssueLog;
import com.houser.devtrac_Using_Intellij.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
@Controller
@RequestMapping("/issues")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @Autowired
    private ProjectService projectService;
    @Autowired
    private IssueStatusService issueStatusService;
    @Autowired
    private IssuePriorityService issuePriorityService;
    @Autowired
    private IssueLogService issueLogService;
    @GetMapping("/list")

    public String listBlankIssues(Model model) {
        model.addAttribute("listProjects", projectService.getAllProjects());
        model.addAttribute("listIssues" , issueService.getAllIssues());
        return "issues/issuesList";
    }
    @GetMapping("/list/{projectid}")
    public String listProjectIssues(@PathVariable(value = "projectid") long projectid,
                                    Model model) {
        model.addAttribute("listProjects", projectService.getAllProjects());
        model.addAttribute("listIssues" ,
                issueService.getIssuesByProjectID(projectid));
        model.addAttribute("ProjectDets" , projectService.getProjectById(projectid));
        model.addAttribute("CurrProjectID", projectid);
        return "issues/issues";
    }
    @GetMapping("/list/{curpjtid}/{issid}")
    public String showIssueDetails(@PathVariable(value = "curpjtid") long curpjtid,
                                   @PathVariable(value = "issid") long issid, Model model) {
        model.addAttribute("listProjects" , projectService.getAllProjects());
        model.addAttribute("listIssues"
                ,
                issueService.getIssuesByProjectID(curpjtid));
        model.addAttribute("thisIssue"
                , issueService.getIssueById(issid));
        model.addAttribute("ProjectDets"
                , projectService.getProjectById(curpjtid));
        model.addAttribute("CurrProjectID" , curpjtid);
        model.addAttribute("issueStatusList", issueStatusService.getAllIssueStatus());
        model.addAttribute("issuePriorsList",
                issuePriorityService.getAllIssuePrioritys());
        IssueLog newIssueLog = new IssueLog();
        newIssueLog.setIssueID(issid);
        newIssueLog.setLogDate(getCurrDate());
        model.addAttribute("newIssueLog"
                , newIssueLog);
        model.addAttribute("issueLogs"
                ,
                issueLogService.getIssueLogsByIssueID(issid));
        return "issues/issuesDetails";
    }
    @GetMapping("/updateissulog/{id}/{projectid}")
    public String UpdateIssueLog(@PathVariable(value = "id") long id, @PathVariable(value
            = "projectid") long projectid, Model model) {
        IssueLog issueLog = issueLogService.getIssueLogById(id);
        model.addAttribute("issueLog", issueLog);
        return "redirect:/issues/list/" + projectid + "/" + issueLog.getId();
    }
    private Date getCurrDate() {
        long millis=System.currentTimeMillis();
        Date date=new java.sql.Date(millis);
        return date;
    }

    @GetMapping("/NewIssue/{projectid}")
    public String showNewIssueForm(@PathVariable(value = "projectid") long projectid,
                                   Model model) {
        Issue issue = new Issue();
        long millis=System.currentTimeMillis();
        Date date=new java.sql.Date(millis);
        issue.setDateReported(date);
        issue.setProjectID(projectid);
        issue.setIssuePriority(3);
        issue.setIssueStatus(1);
        model.addAttribute("issue", issue);
        model.addAttribute("ProjectDets" , projectService.getProjectById(projectid));
        model.addAttribute("CurrProjectID", projectid);
        model.addAttribute("issueStatusList", issueStatusService.getAllIssueStatus());
        return "issues/newIssue";
    }
    @PostMapping("/saveissue")
    public String saveProjectIssue(@ModelAttribute("thisIssue") Issue thisIssue) {
        issueService.saveIssue(thisIssue); // save Issue to database
        return "redirect:/issues/list/" + thisIssue.getProjectID() + "/" +
                thisIssue.getId();
    }
    @PostMapping("/savenewissue")
    public String saveNewProjectIssue(@ModelAttribute("thisIssue") Issue thisIssue) {
        issueService.saveIssue(thisIssue);
        return "redirect:/issues/list/" + thisIssue.getProjectID() + "/" +
                thisIssue.getId();
    }
    @PostMapping("/saveissuelog/{curpjtid}")
    public String saveProjectIssueLog(@ModelAttribute("thisIssueLog") IssueLog
                                              thisIssueLog, @PathVariable(value = "curpjtid") long curpjtid ) {
        issueLogService.saveIssueLog(thisIssueLog); // save Issue Log to database
        return "redirect:/issues/list/" + curpjtid + "/" + thisIssueLog.getIssueID();
    }


}
