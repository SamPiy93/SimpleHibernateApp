/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * Role Model to map role relational table
 */
@Entity
@Table(name = "ROLE")
public class Role {
    @Id 
    @Column(name = "roleid")
    @SequenceGenerator(name = "seq", sequenceName = "sequence_role")    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int roleid;
    @Column(name = "title")
    private String title;
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "role", cascade = CascadeType.ALL)
    private Employee employee;
    /**
     * Getters and Setters
     * 
     */
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
}
