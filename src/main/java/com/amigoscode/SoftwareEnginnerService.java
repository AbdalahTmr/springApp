package com.amigoscode;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEnginnerService {

    private final SERepository seRepository;

    public SoftwareEnginnerService(SERepository softwareEngine) {
        this.seRepository = softwareEngine;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return seRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        seRepository.save(softwareEngineer);
    }

    public void updateSoftwareEngineer(Integer id,
            SoftwareEngineer update) {
        SoftwareEngineer softwareEngineer = seRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + " not found"));
        softwareEngineer.setName(update.getName());
        softwareEngineer.setTechStack(update.getTechStack());
        seRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerId(Integer id) {

         return seRepository.findById(id).orElseThrow(() ->
                 new RuntimeException("SoftwareEngineer with id "
                 + id + " not found"));
    }

    public void deleteEngineerById(Integer id) {
        boolean exists =  seRepository.existsById(id);
        if (!exists) {
            throw new RuntimeException("SoftwareEngineer with id "
                    + id + " not found");
        }
        seRepository.deleteById(id);
    }


}
