package com.amigoscode;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEnginnerService softwareEnginnerService;

    public SoftwareEngineerController(SoftwareEnginnerService softwareEnginnerService) {
        this.softwareEnginnerService = softwareEnginnerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineer() {
        return softwareEnginnerService.getAllSoftwareEngineers();
    }

    @PostMapping
    public void addNewSoftwareEngineer(
            @RequestBody SoftwareEngineer softwareEngineer) {
         softwareEnginnerService.insertSoftwareEngineer(softwareEngineer);
    }

    @PutMapping("{id}")
   public void updateSoftwareEngineer(
           @PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer)
            {
        softwareEnginnerService.updateSoftwareEngineer(id, softwareEngineer);
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(
            @PathVariable Integer id
    ) {
        return softwareEnginnerService.getSoftwareEngineerId(id);
    }

    @DeleteMapping({"id"})
    public void deleteEngineerById(
            @PathVariable Integer id
    ) {
       softwareEnginnerService.deleteEngineerById(id);
    }

}
