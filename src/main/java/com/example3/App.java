package com.example3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example3.entity.Student;


public class App 
{
    public static void main( String[] args )
    {
      System.out.println("Connection started"); 
      Configuration cfg=new Configuration();
      cfg.configure("hibernate.cfg.xml");
      SessionFactory factory=cfg.buildSessionFactory();
      Session session=factory.openSession();
      try
      {
    	  //Insert student details into student table
    	  
    	  for(int i=1;i<=5;i++)
    	  {
    		  Student student=new Student();
    		  student.setName("Student"+i);
    		  session.save(student);
    	  }
    	  
    	  //Retrive the details of a Student
    	    
            Student student=session.get(Student.class,4);
            System.out.println("student name:"+student.getName());
            session.save(student);
            
            //Update the Student
              
          Student student1=session.get(Student.class,11);
          student.setName("Ram");
          session.update(student);
          
          //Delete the Student
  	      
  	      Student student2=session.get(Student.class, 17);
  	      session.delete(student);
          
          
          Student r1=session.get(Student.class, student.getId());
          System.out.println("Student: "+student.getName());


       

           session.beginTransaction();
  	     session.getTransaction().commit();
           
            
            
    	      
            

           
    	  
      }
      catch(Exception e)
      {
    	  e.printStackTrace();
      }
      finally
      {
    	  session.close();
    	  factory.close();
      }
      
    }
}
