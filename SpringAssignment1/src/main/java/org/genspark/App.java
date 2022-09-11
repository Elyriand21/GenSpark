package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringAssignment1.xml");

        Student student = (Student) context.getBean("student");
        student.doHomework();

        Phone phone = (Phone) context.getBean("phone");
        System.out.println("Constructor Method for the Phone");
        System.out.println(phone);

        // Setter methods are being dealt with in the XML file
    }
}
