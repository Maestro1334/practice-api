package nl.inholland.practiceapi.service;

import nl.inholland.practiceapi.model.GPU;
import nl.inholland.practiceapi.model.VRAMType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GPUService {
    private final List<GPU> gpus;

    public GPUService() {
        this.gpus = Arrays.asList(
                new GPU(1L, "RX580", 1340, 8, VRAMType.GDDR5),
                new GPU(2L, "Titan RTX", 1770, 24, VRAMType.GDDR6),
                new GPU(3L, "GeForce RTX 2080 Super", 1815, 8, VRAMType.GDDR6),
                new GPU(4L, "Titan X", 1480, 12, VRAMType.GDDR5),
                new GPU(5L, "GeForce GTX 1080 Ti", 1582, 11, VRAMType.GDDR5)
        );
    }

    public List<GPU> getAllGPUs() {
        sortGPUsByClock();
        return gpus;
    }

    private void sortGPUsByClock() {
        // Sort GPUs by clock descending
        gpus.sort((g1, g2) -> (int) (g2.getClock() - g1.getClock()));
    }

    public List<GPU> getAllDDR6GPUs() {
        Stream<GPU> gpuStream = gpus.stream(); // Convert list to stream
        List<GPU> ddr6Gpus = gpuStream.filter( // Filter on GDDR6 and convert back to list
                a -> a.getVramType().equals(VRAMType.GDDR6))
                .collect(Collectors.toList());
        return ddr6Gpus;
    }
}
