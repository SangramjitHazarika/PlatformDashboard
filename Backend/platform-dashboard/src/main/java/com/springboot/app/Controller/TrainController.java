package com.springboot.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.Model.Train;
import com.springboot.app.Repository.TrainRepository;
import java.util.Optional;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    @Autowired
    private TrainRepository trainRepository;

    @GetMapping
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    @PostMapping
    public Train addTrain(@RequestBody Train train) {
        return trainRepository.save(train);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable Long id, @RequestBody Train updatedTrain) {
        Optional<Train> existingTrainOptional = trainRepository.findById(id);

        if (existingTrainOptional.isPresent()) {
            Train existingTrain = existingTrainOptional.get();
            existingTrain.setTrainName(updatedTrain.getTrainName());
            existingTrain.setPlatform(updatedTrain.getPlatform());
            existingTrain.setArrivalTime(updatedTrain.getArrivalTime());

            Train savedTrain = trainRepository.save(existingTrain);
            return ResponseEntity.ok(savedTrain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

