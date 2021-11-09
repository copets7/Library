package by.itstep;

import by.itstep.config.AppConfiguration;
import by.itstep.controllers.*;
import by.itstep.controllers.impl.*;
import by.itstep.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Run {

    @Autowired
    UserController userController;
    @Autowired
    RoleController roleController;
    @Autowired
    BookController bookController;
    @Autowired
    TypeGenreController typeGenreController;
    @Autowired
    StatusController statusController;
    @Autowired
    BookListController bookListController;
    @Autowired
    LogRecordController logRecordController;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotatedClassApplicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Run run = annotatedClassApplicationContext.getBean("run", Run.class);



        System.out.println(run.roleController.findAll());
        User user = new User();
        user.setUserName("qwrqre");
        user.setEmail("qwrq@mail.by");
        user.setPassword("21414");
        user.setRole(run.roleController.findById(3));

        run.userController.save(user);

//        System.out.println(run.typeGenreControllerImpl.findById(1));
//        System.out.println(run.bookControllerImpl.findAll());
        System.out.println(run.userController.findAll());
//        System.out.println(run.statusControllerImpl.findAll());
//        System.out.println(run.bookListControllerImpl.findAll());
//        System.out.println(run.logRecordControllerImpl.findAll());
    }
}
