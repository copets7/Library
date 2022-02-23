package by.itstep.controllers.rest;

import by.itstep.models.Status;
import by.itstep.service.StatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book-status")
@Api(value = "book-status")
public class StatusRestController {

    private final StatusService statusService;

    public StatusRestController(StatusService statusService) {
        this.statusService = statusService;
    }

    @ApiOperation(value = "Метод находит все статусы")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAllStatus() {
        List<Status> statusList = statusService.findAll();

        return statusList != null &&  !statusList.isEmpty()
                ? new ResponseEntity<>(statusList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод добавляет новый статус")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveStatus(@RequestBody Status status) {
        statusService.save(status);
        return  status!= null
                ? new ResponseEntity<>(status , HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Метод находит один статус")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOneStatus(@PathVariable("id") int statusId) {
        final Status status = this.statusService.findById(statusId);
        return status != null
                ? new ResponseEntity<>(status, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод редактирует статус")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateStatus(@RequestBody Status status){
        statusService.save(status);
        return status != null
                ? new ResponseEntity<>(status , HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод удаляет статус")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Status> deleteStatus(@PathVariable int id){
        final Status status = this.statusService.findById(id);
        statusService.delete(status);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
