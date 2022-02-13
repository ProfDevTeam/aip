package com.service.vterminal.api.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.vterminal.ConfigUtils;
import com.service.vterminal.api.dto.ConfigResponse;
import com.service.vterminal.exception.ExceptionWithStatusCode;
import com.service.vterminal.exception.MessageKeyConstants;
import com.service.vterminal.model.ConfigValidationSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class ConfigService {
    private final Logger logger = Logger.getLogger(ConfigService.class.getName());

    @Value("${upload.filepath}")
    private String filePath;

    private final ObjectMapper objectMapper;

    public ConfigService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<?> getConfigData() {
        try {
            File file = Paths.get(filePath).toFile();
            if (!file.exists()) {
                return new ResponseEntity<>(MessageKeyConstants.CONFIG_NOT_FOUND, HttpStatus.NOT_FOUND);
            } else {
                ConfigValidationSchema configValidationSchema = objectMapper.readValue(file, ConfigValidationSchema.class);
                ConfigResponse res = ConfigUtils.buildConfigResponse(configValidationSchema, file.getAbsolutePath());
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
        } catch (IOException e) {
            throw new ExceptionWithStatusCode(500, MessageKeyConstants.SOMETHING_WENT_WRONG);

        }
    }

    public ResponseEntity<?> setConfigData(ConfigValidationSchema configValidationSchema) {
        ConfigUtils.checkConfigValidationSchema(configValidationSchema);
        try {
            File file = Paths.get(filePath).toFile();
            if (!file.exists()) {
                return new ResponseEntity<>(MessageKeyConstants.CONFIG_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
            objectMapper.writeValue(file, configValidationSchema);
            ConfigResponse res = ConfigUtils.buildConfigResponse(configValidationSchema, file.getAbsolutePath());
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (JsonMappingException exc) {
            logger.log(Level.SEVERE, MessageKeyConstants.BAD_REQUEST, exc);
            throw new ExceptionWithStatusCode(400,MessageKeyConstants.BAD_REQUEST);
        } catch (IOException e) {
            logger.log(Level.SEVERE, MessageKeyConstants.FAILED_TO_WRITE_TO_JSON, e);
            throw new ExceptionWithStatusCode(500,MessageKeyConstants.FAILED_TO_WRITE_TO_JSON);
        }
    }
}
