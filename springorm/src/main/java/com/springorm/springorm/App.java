package com.springorm.springorm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springorm.springorm.dao.StudentDao;
import com.springorm.springorm.entities.Student;
public class App 
{
    public static void main( String[] args )
    {  
    	ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
    	StudentDao st=con.getBean("studentDao",StudentDao.class);
    	/*Student stu=new Student(212,"Vishal","Jaunpur");
    	int r=st.insert(stu);
        System.out.println("inserted student is:"+ r);*/
    	Student stu=st.getStudent(212);
    	 System.out.println(stu);
    }
}
