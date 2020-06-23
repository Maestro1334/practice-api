package nl.inholland.practiceapi.service;

import nl.inholland.practiceapi.model.GPU;
import nl.inholland.practiceapi.model.VRAMType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GPUService {
    List<GPU> gpus;

    public GPUService() {
        this.gpus = Arrays.asList(
                new GPU(1L, "RX580", 1340, 8, VRAMType.GDDR5),
                new GPU(2L, "Titan RTX", 1770, 24, VRAMType.GDDR6),
                new GPU(3L, "GeForce RTX 2080 Super", 1815, 8, VRAMType.GDDR6),
                new GPU(4L, "Titan X", 1480, 12, VRAMType.GDDR5),
                new GPU(5L, "GeForce GTX 1080 Ti", 1582, 11, VRAMType.GDDR5)
        );
    }

    public List<GPU> getAllGpus() {
        return gpus;
    }
}
