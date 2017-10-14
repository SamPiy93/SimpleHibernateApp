/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.helper;

import java.util.List;
import com.hr.models.Employee;
import com.hr.models.Role;
import com.hr.models.Task;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * Helper class for ORM
 */
public class HRHelper {

    private SessionFactory sessionFactory = null;
    
    public HRHelper() {
        this.sessionFactory = HRSessionUtil.getSessionFactory();
    }
    /**
     * Get employee list method
     * 
     */
    public List getEmployeeList(){
        List<Employee> employeeList = null;
        Transaction transaction = null;
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee");
            employeeList = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally{
            session.close();
        }
        return employeeList;
    }
    /**
     * Save Employee method
     * 
     */
    public void saveEmployee(Employee employee){
        Transaction transaction = null;
        Session session = null;
        try{
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        } catch(HibernateException e){
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally{
            session.close();
        }
    }
    /**
     * Save role method
     * 
     */
    public void saveRole(Role role){
        Transaction transaction = null;
        Session session = null;
        try{
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(role);
            transaction.commit();
        } catch(HibernateException e){
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally{
            session.close();
        }
    }
    /**
     * Get roles list method
     * 
     */
    public List getRoleList(){
        List<Role> roleList = null;
        Transaction transaction = null;
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Role");
            roleList = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally{
            session.close();
        }
        return roleList;
    }
    /**
     * Get tasks list method
     * 
     */
    public List getTaskList(){
        List<Task> taskList = null;
        Transaction transaction = null;
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Task");
            taskList = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally{
            session.close();
        }
        return taskList;
    }
    /**
     * Save tasks list method
     * 
     */
    public void saveTask(Task task){
        Transaction transaction = null;
        Session session = null;
        try{
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(task);
            transaction.commit();
        } catch(HibernateException e){
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally{
            session.close();
        }
    }
    /**
     * Update tasks list of an employee method
     * 
     */
    public void removeTasksFromEmployeeByEmployeeid(Employee employee){
        Transaction transaction = null;
        Session session = null;
        try{
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("UPDATE TASK SET EMPLOYEE=NULL WHERE EMPLOYEE="+employee.getEmployeeid());
            query.executeUpdate();
            for(Task task: employee.getTasks()){
                query = session.createSQLQuery("UPDATE TASK SET EMPLOYEE="+employee.getEmployeeid()+" WHERE TASKID="+task.getTaskid());
                query.executeUpdate();
            }
            transaction.commit();
        } catch(HibernateException e){
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally{
            session.close();
        }
    }
}
