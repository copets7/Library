package by.itstep.controllers.rest;

import by.itstep.models.LogRecord;
import by.itstep.service.LogRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@Api(value = "/records")
public class LogRecordRestController {

    private final LogRecordService recordService;

    public LogRecordRestController(LogRecordService recordService) {
        this.recordService = recordService;
    }


    @ApiOperation(value = "Метод находит все записи")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<LogRecord>> findAllRecords() {
        List<LogRecord> logRecordList = recordService.findAll();

        return logRecordList != null &&  !logRecordList.isEmpty()
                ? new ResponseEntity<>(logRecordList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод добавляет новую запись")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveRecord(@RequestBody LogRecord logRecord) {
        recordService.save(logRecord);
        return  logRecord!= null
                ? new ResponseEntity<>(logRecord , HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Метод находит одну запись")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LogRecord> getOneRecord(@PathVariable("id") int recordId) {
        final LogRecord logRecord = this.recordService.findById(recordId);
        return logRecord != null
                ? new ResponseEntity<>(logRecord, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод редактирует запись")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<LogRecord> updateRecord(@RequestBody LogRecord logRecord){
        recordService.save(logRecord);
        return logRecord != null
                ? new ResponseEntity<>(logRecord , HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод удаляет запись")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<LogRecord> deleteRecord(@PathVariable int id){
        final LogRecord logRecord = this.recordService.findById(id);
        recordService.delete(logRecord);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
