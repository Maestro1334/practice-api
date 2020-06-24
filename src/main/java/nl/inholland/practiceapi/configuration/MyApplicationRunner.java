package nl.inholland.practiceapi.configuration;

import nl.inholland.practiceapi.dao.ApiKeyRepository;
import nl.inholland.practiceapi.dao.GPURepository;
import nl.inholland.practiceapi.dao.StockRepository;
import nl.inholland.practiceapi.model.ApiKey;
import nl.inholland.practiceapi.model.GPU;
import nl.inholland.practiceapi.model.Stock;
import nl.inholland.practiceapi.model.VRAMType;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private final GPURepository gpuRepository;
    private final StockRepository stockRepository;
    private final PropertyConfiguration properties;
    private final ApiKeyRepository apiKeyRepository;

    public MyApplicationRunner(GPURepository gpuRepository, StockRepository stockRepository, PropertyConfiguration properties, ApiKeyRepository apiKeyRepository) {
        this.gpuRepository = gpuRepository;
        this.stockRepository = stockRepository;
        this.properties = properties;
        this.apiKeyRepository = apiKeyRepository;
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

        gpuRepository.findAll().forEach(gpu -> stockRepository.save(new Stock(new Random().nextInt(50), gpu)));

        stockRepository.findAll().forEach(System.out::println);

        apiKeyRepository.save(new ApiKey("1qX6Y51NUa"));

        properties.setApplicationName("Practice-API");
        System.out.println(properties.getApplicationName());

        apiKeyRepository.findAll().forEach(System.out::println);



        //stockRepository.getAllByQuantityGreaterThanEqualOrderByQuantity(25).forEach(System.out::println);

        //System.out.println(stockRepository.getStockByGpu_Id(1000L));

        //System.out.println(stockRepository.getTotalClockValueOfStockByGpuId(1000L));
    }
}
