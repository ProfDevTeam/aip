package com.service.vterminal.api.dto;

import com.service.vterminal.model.ConfigValidationSchema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigResponse {
    ConfigValidationSchema configValidationSchema;
    String filePath;
    String msg;


}
