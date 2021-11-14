package by.itstep.controllers.impl;

import by.itstep.controllers.LogRecordController;
import by.itstep.models.LogRecord;
import by.itstep.models.User;
import by.itstep.service.LogRecordService;
import by.itstep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/record")
public class LogRecordControllerImpl implements LogRecordController {

    private final LogRecordService logRecordService;
    private final UserService userService;

    public LogRecordControllerImpl(LogRecordService logRecordService, UserService userService) {
        this.logRecordService = logRecordService;
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("logs", logRecordService.findAll());
        return "record/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("log", logRecordService.findById(id));
        return "record/show";
    }

    @GetMapping("/new")
    public String newRecord(@ModelAttribute("log") LogRecord logRecord, Model model) {
        model.addAttribute("log", logRecordService.findAll());
        return "record/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("log") LogRecord logRecord ,@RequestParam("id") int id) {
        logRecord.setUser(userService.findById(id));
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
        model.addAttribute("log", logRecordService.findAll());
        LogRecord logRecord = logRecordService.findById(id);
        model.addAttribute("log",logRecord);
        return "record/edit";
    }

    @PostMapping("/edit")
    public String updateRecord(LogRecord logRecord,@RequestParam("role.id") int userId){
        logRecord.setUser(userService.findById(userId));
        logRecordService.save(logRecord);
        return "redirect:/record";
    }


    @Override
    public List<LogRecord> findAll() {
        return logRecordService.findAll();
    }

    @Override
    public LogRecord findById(int id) {
        return logRecordService.findById(id);
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
