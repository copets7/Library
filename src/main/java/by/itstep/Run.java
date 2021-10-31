package by.itstep;

import by.itstep.config.AppConfiguration;
import by.itstep.controllers.RoleController;
import by.itstep.controllers.impl.*;
import by.itstep.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Run {

    @Autowired
    UserControllerImpl userControllerImpl;
    @Autowired
    RoleControllerImpl roleControllerImpl;
    @Autowired
    BookControllerImpl bookControllerImpl;
    @Autowired
    TypeGenreControllerImpl typeGenreControllerImpl;
    @Autowired
    StatusControllerImpl statusControllerImpl;
    @Autowired
    BookListControllerImpl bookListControllerImpl;
    @Autowired
    LogRecordControllerImpl logRecordControllerImpl;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotatedClassApplicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Run run = annotatedClassApplicationContext.getBean("run", Run.class);


      run.userControllerImpl.deleteById(2);
//        System.out.println(run.roleControllerImpl.findAll());
//        System.out.println(run.typeGenreControllerImpl.findById(1));
//        System.out.println(run.bookControllerImpl.findAll());
//        System.out.println(run.userControllerImpl.findAll());
//        System.out.println(run.statusControllerImpl.findAll());
//        System.out.println(run.bookListControllerImpl.findAll());
//        System.out.println(run.logRecordControllerImpl.findAll());
    }

    public StatusControllerImpl getStatusControllerImpl() {
        return statusControllerImpl;
    }

    public void setStatusControllerImpl(StatusControllerImpl statusControllerImpl) {
        this.statusControllerImpl = statusControllerImpl;
    }

    public BookListControllerImpl getBookListControllerImpl() {
        return bookListControllerImpl;
    }

    public void setBookListControllerImpl(BookListControllerImpl bookListControllerImpl) {
        this.bookListControllerImpl = bookListControllerImpl;
    }

    public LogRecordControllerImpl getLogRecordController() {
        return logRecordControllerImpl;
    }

    public void setLogRecordController(LogRecordControllerImpl logRecordController) {
        this.logRecordControllerImpl = logRecordController;
    }

    public BookControllerImpl getBookControllerImpl() {
        return bookControllerImpl;
    }

    public void setBookControllerImpl(BookControllerImpl bookControllerImpl) {
        this.bookControllerImpl = bookControllerImpl;
    }

    public TypeGenreControllerImpl getTypeGenreControllerImpl() {
        return typeGenreControllerImpl;
    }

    public void setTypeGenreControllerImpl(TypeGenreControllerImpl typeGenreControllerImpl) {
        this.typeGenreControllerImpl = typeGenreControllerImpl;
    }

    public UserControllerImpl getUserControllerImpl() {
        return userControllerImpl;
    }

    public void setUserControllerImpl(UserControllerImpl userControllerImpl) {
        this.userControllerImpl = userControllerImpl;
    }

    public RoleControllerImpl getRoleControllerImpl() {
        return roleControllerImpl;
    }

    public void setRoleControllerImpl(RoleControllerImpl roleControllerImpl) {
        this.roleControllerImpl = roleControllerImpl;
    }
}
