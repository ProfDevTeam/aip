package com.service.vterminal.api.controller;

import com.service.vterminal.api.dto.ConfigResponse;
import com.service.vterminal.model.ConfigValidationSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/config")
public class ConfigController {

    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }


    @GetMapping(path = "/get-config-data")
    public ResponseEntity<?> getConfigData() {
        return configService.getConfigData();
    }

    @PostMapping(path = "/set-config-data")
    public ResponseEntity<?> setConfigData(@RequestBody ConfigValidationSchema configValidationSchema) {
        return configService.setConfigData(configValidationSchema);
    }
}
