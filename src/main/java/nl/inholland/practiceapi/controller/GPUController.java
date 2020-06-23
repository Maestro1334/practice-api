package nl.inholland.practiceapi.controller;

import nl.inholland.practiceapi.model.GPU;
import nl.inholland.practiceapi.service.GPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("gpus")
public class GPUController {

    @Autowired
    private GPUService gpuService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllGPUs() {
        List<GPU> gpus = gpuService.getAllGPUs();
        return ResponseEntity.status(200).body(gpus);
    }

    @RequestMapping(value = "ddr6", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAmdGPUs() {
        List<GPU> gpus = gpuService.getAllDDR6GPUs();
        return ResponseEntity.status(200).body(gpus);
    }

    @RequestMapping(value = "clock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllGPUsSortedByClock() {
        List<GPU> gpus = gpuService.getAllGPUsSortedByClock();
        return ResponseEntity.status(200).body(gpus);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getGPUById(@PathVariable long id) {
        try {
            GPU gpu = gpuService.findGPUById(id);
            return ResponseEntity.status(HttpStatus.OK).body(gpu);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGPU(@RequestBody GPU gpu){
        gpuService.addGPU(gpu);
        return ResponseEntity.status(HttpStatus.CREATED).body(gpu.getId());
    }
}
