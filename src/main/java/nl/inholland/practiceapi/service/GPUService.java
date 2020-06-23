package nl.inholland.practiceapi.service;

import nl.inholland.practiceapi.dao.GPURepository;
import nl.inholland.practiceapi.model.GPU;
import nl.inholland.practiceapi.model.VRAMType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GPUService {

    private final GPURepository gpuRepository;

    public GPUService(GPURepository gpuRepository) {
        this.gpuRepository = gpuRepository;
    }

    public List<GPU> getAllGPUs() {
        return (List<GPU>)gpuRepository.findAll();
    }

    public List<GPU> getAllGPUsSortedByClock() {
        List<GPU> gpus = getAllGPUs();
        // Sort GPUs by clock descending
        gpus.sort((g1, g2) -> (int) (g2.getClock() - g1.getClock()));
        return gpus;
    }

    public List<GPU> getAllDDR6GPUs() {
        List<GPU> gpus = getAllGPUs();
        Stream<GPU> gpuStream = gpus.stream(); // Convert list to stream
        return gpuStream.filter( // Filter on GDDR6 and convert back to list
                a -> a.getVramType().equals(VRAMType.GDDR6))
                .collect(Collectors.toList());
    }
}
