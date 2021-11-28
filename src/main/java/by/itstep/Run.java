package by.itstep;

import by.itstep.config.AppConfiguration;
import by.itstep.controllers.*;
import by.itstep.controllers.impl.*;
import by.itstep.models.*;
import by.itstep.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

//@Component
//public class Run {
//
//    @Autowired
//    UserController userController;
//    @Autowired
//    RoleController roleController;
//    @Autowired
//    BookController bookController;
//    @Autowired
//    TypeGenreController typeGenreController;
//    @Autowired
//    StatusController statusController;
//    @Autowired
//    LogRecordController logRecordController;
//
//    @Autowired
//    BookService bookService;
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotatedClassApplicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        Run run = annotatedClassApplicationContext.getBean("run", Run.class);
//

//
//        User user = new User();
//        user.setUserName("qwrqre");
//        user.setEmail("qwrq@mail.by");
//        user.setPassword("21414");
//        user.setRole(run.roleController.findById(3));
//
//        Book book = new Book();
//
//        Status status = new Status();
//        status.setStatusName("on hand");
//        run.statusController.save(status);
//        run.userController.save(user);
//        LogRecord logRecord = new LogRecord();
//        logRecord.setLibCode("qwq");
//        logRecord.setUser(user);
//        logRecord.setStatus(status);
//        logRecord.setCreateDate("12.12.2021");
//        logRecord.setCloseDate("12.02.2022");
//        logRecord.setCreateBy("CopetS");
//        logRecord.setBooks( run.bookController.findAll());
//        run.logRecordController.save(logRecord);


//        System.out.println(run.typeGenreControllerImpl.findById(1));
//        System.out.println(run.bookControllerImpl.findAll());
//        System.out.println(run.userController.findAll());
       // System.out.println(run.logRecordController.findAll());
//        System.out.println(run.statusControllerImpl.findAll());
//        System.out.println(run.bookListControllerImpl.findAll());
//        System.out.println(run.logRecordControllerImpl.findAll());
//    }
//}
