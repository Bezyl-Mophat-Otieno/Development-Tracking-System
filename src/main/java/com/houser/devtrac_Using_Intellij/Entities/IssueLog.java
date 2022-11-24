package com.houser.devtrac_Using_Intellij.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "issuelogs")
public class IssueLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "logdate")
    private Date logDate ;
    @Column(name = "issueid")
    private Long issueID;
    @Column(name = "hours")
    private Double hours ;
    @Column(name = "description")
    private String description ;
    public Long getIssueID() {
        return issueID;
    }

    public void setIssueID(Long issueID) {
        this.issueID = issueID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getLogDate() {
        return logDate;
    }
    public void setLogDate(Date IssueDate) {
        this.logDate = IssueDate;
    }
    public Double getHours() {
        return hours;
    }
    public void setHours(Double hours) {
        this.hours = hours;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
