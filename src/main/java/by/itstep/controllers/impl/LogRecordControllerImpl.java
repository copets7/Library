package by.itstep.controllers.impl;

import by.itstep.controllers.LogRecordController;
import by.itstep.models.LogRecord;
import by.itstep.service.BookService;
import by.itstep.service.LogRecordService;
import by.itstep.service.StatusService;
import by.itstep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/record")
public class LogRecordControllerImpl implements LogRecordController {

    private final LogRecordService logRecordService;
    private final BookService bookService;
    private final UserService userService;
    private final StatusService statusService;

    public LogRecordControllerImpl(LogRecordService logRecordService, BookService bookService, UserService userService, StatusService statusService) {
        this.logRecordService = logRecordService;
        this.bookService = bookService;
        this.userService = userService;
        this.statusService = statusService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("records", logRecordService.findAll());
        return "record/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("record", logRecordService.findById(id));
        return "record/show";
    }

    @GetMapping("/new")
    public String newRecord(@ModelAttribute("record") LogRecord logRecord, Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("status", statusService.findAll());
        return "record/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("record") LogRecord logRecord ,
                         @RequestParam("b") int bookId,
                         @RequestParam("u") int userId,
                         @RequestParam("s") int statusId) {
        logRecord.setBook(bookService.findById(bookId));
        logRecord.setUser(userService.findById(userId));
        logRecord.setStatus(statusService.findById(statusId));
        logRecordService.save(logRecord);
        return "redirect:/record";
    }

    @GetMapping("delete/{id}")
    public String deleteRecord(@PathVariable("id")int id){
        logRecordService.deleteById(id);
        return "redirect:/record";
    }

    @GetMapping("edit/{id}")
    public String updateRecordForm(@PathVariable("id") int id ,Model model){
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("status", statusService.findAll());
        LogRecord logRecord = logRecordService.findById(id);
        model.addAttribute("record", logRecord);
        return "record/edit";
    }

    @PostMapping("/edit")
    public String updateRecord(LogRecord logRecord,
                               @RequestParam("b") int bookId,
                               @RequestParam("u") int userId,
                               @RequestParam("s") int statusId){
        logRecord.setBook(bookService.findById(bookId));
        logRecord.setUser(userService.findById(userId));
        logRecord.setStatus(statusService.findById(statusId));
        logRecordService.save(logRecord);
        return "redirect:/record";
    }


    @Override
    public List<LogRecord> findAll() {
        return logRecordService.findAll();
    }

    @Override
    public LogRecord findById(int id) {
        return  logRecordService.findById(id);
    }

    @Override
    public LogRecord save(LogRecord logRecord) {
        return logRecordService.save(logRecord);
    }

    @Override
    public LogRecord update(LogRecord logRecord) {
        return logRecordService.update(logRecord);
    }

    @Override
    public void delete(LogRecord logRecord) {
            logRecordService.delete(logRecord);
    }

    @Override
    public void deleteById(int id) {
            logRecordService.deleteById(id);
    }
}
