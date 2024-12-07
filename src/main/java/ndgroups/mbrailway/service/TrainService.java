package ndgroups.mbrailway.service;

import jakarta.persistence.EntityNotFoundException;
import ndgroups.mbrailway.model.Train;
import ndgroups.mbrailway.repository.TrainRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    public Train saveTrain(Train train){
        return trainRepository.save(train);
    }

    public List<Train> getAllTrains()  {
        return trainRepository.findAll();
    }
    public Train getOneTrain(Integer id) {
        return trainRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Train not found with id: " + id));
    }

    public Train updateTrain(Integer id, Train train) {
        Train existingTrain  = trainRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("train not found"));

        // Copy updated fields to existing product (excluding id)
        BeanUtils.copyProperties(train,existingTrain, "id");

        return trainRepository.save(existingTrain);
    }

    public void deleteTrain(Integer id) {
        if (!trainRepository.existsById(id)) {
            throw new EntityNotFoundException("Train not found with id: " + id);
        }
        trainRepository.deleteById(id);
    }
}
