package nl.inholland.practiceapi.controller;

import nl.inholland.practiceapi.model.GPU;
import nl.inholland.practiceapi.service.GPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}
