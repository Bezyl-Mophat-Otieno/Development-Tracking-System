package com.houser.devtrac_Using_Intellij.Entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "projects", uniqueConstraints = @UniqueConstraint(columnNames = "projecttitle"))
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "projecttitle")
    private String projectTitle;
    @Column(name = "projectdescrip")
    private String projectDescrip;
    @Column(name = "startdate")
    private Date startDate;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getProjectTitle() {
        return projectTitle;
    }
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getProjectDescrip() {
        return projectDescrip;
    }
    public void setProjectDescrip(String projectDescrip) {
        this.projectDescrip = projectDescrip;
    }

}
