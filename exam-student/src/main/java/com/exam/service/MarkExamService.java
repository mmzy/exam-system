package com.exam.service;

import com.exam.pojo.Examhis;
import com.exam.service.impl.ExamHisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentLinkedQueue;
@Component
public class MarkExamService implements Runnable {
    public void run() {
        ApplicationContext context= new ClassPathXmlApplicationContext("/spring/applicationContext-dao.xml",
                    "/spring/applicationContext-service.xml","/spring/applicationContext-trans.xml","/spring/springmvc" +
                    ".xml");
        ExamHisService examHisService = (ExamHisService)context.getBean("examHisServiceImpl");
        Examhis thisExamhis = null;
        while((thisExamhis =ExamHisServiceImpl.getExamHisQuery().peek())!=null){

            if(thisExamhis!=null){
                examHisService.MarkingExam(thisExamhis,context);
                ExamHisServiceImpl.getExamHisQuery().poll();
                thisExamhis = null;
            }else{
                try {
                    Thread.sleep(1000 * 60 * 5 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @PostConstruct
    public void startMarkExam(){
        new Thread(this).start();
    }
}
