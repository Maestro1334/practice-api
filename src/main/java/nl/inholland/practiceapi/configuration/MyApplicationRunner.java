package nl.inholland.practiceapi.configuration;

import nl.inholland.practiceapi.dao.GPURepository;
import nl.inholland.practiceapi.model.GPU;
import nl.inholland.practiceapi.model.VRAMType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    final GPURepository gpuRepository;

    public MyApplicationRunner(GPURepository gpuRepository) {
        this.gpuRepository = gpuRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<GPU> gpus = Arrays.asList(
                new GPU("RX580", 1340, 8,VRAMType.GDDR5),
                new GPU("Titan RTX", 1770, 24, VRAMType.GDDR6),
                new GPU("GeForce RTX 2080 Super", 1815, 8, VRAMType.GDDR6),
                new GPU("Titan X", 1480, 12, VRAMType.GDDR5),
                new GPU("GeForce GTX 1080 Ti", 1582, 11, VRAMType.GDDR5)
        );

        gpuRepository.saveAll(gpus);

        gpuRepository.findAll().forEach(System.out::println);
    }
}
