package com.houser.devtrac_Using_Intellij.Entities;

import javax.persistence.*;


@Entity
@Table(name = "issuestatus", uniqueConstraints = @UniqueConstraint(columnNames =
        "statusname"))
public class IssueStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "statusname")
    private String statusName;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }



}
