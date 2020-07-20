/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests_Edgar.pojos;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pojo.StudentPojo;

/**
 *
 * @author edgar
 */
public class StudentPojoTest {
    
    private StudentPojo student;
    
    @Before
    public void initializeInstace(){
        this.student = new StudentPojo();
    }
    
    @Test
    public void setAndGetIdTest() throws Exception{
        int id = 1;
        student.setUserId(id);
        assertEquals(id, student.getUserId());
    }
    
    @Test
    public void setAndGetEnrollmentTest() throws Exception{
        String enrollment = "S18012122";
        student.setEnrollment(enrollment);
        assertEquals(enrollment, student.getEnrollment());
    }
    
    @Test
    public void setAndGetNamesTest() throws Exception{
        String names = "Edgar";
        student.setName(names);
        assertEquals(names, student.getName());
    }
    
    @Test
    public void setAndGetLastNameTest() throws Exception{
        String lastName = "Viveros";
        student.setLastName(lastName);
        assertEquals(lastName, student.getLastName());
    }
    
    @Test
    public void setAndGetEmailTest() throws Exception{
        String email = "edgarhv221099@gmail.com";
        student.setEmail(email);
        assertEquals(email, student.getEmail());
    }
    
    @Test
    public void setAndGetPasswordTest() throws Exception{
        String password = "12345";
        student.setPassword(password);
        assertEquals(password, student.getPassword());
    }
    
    @Test
    public void setAndGetTypeTest() throws Exception{
        String type = "estudiante";
        student.setType(type);
        assertEquals(type, student.getType());
    }
    
    @Test
    public void setAndGetPhoneTest() throws Exception{
        String phone = "2287549119";
        student.setPhone(phone);
        assertEquals(phone, student.getPhone());
    }
}
