package com.kk.demo.springsecurity.model.converter;

import com.kk.demo.springsecurity.model.enums.Activation;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

/**
 * 狀態類型 Converter
 */
@Slf4j
@Converter
public class ActivationConverter implements AttributeConverter<Activation, String> {

    @Override
    public String convertToDatabaseColumn(Activation obj) {
        return Optional.ofNullable(obj)
                .map(Enum::name)
                .orElse(null);
    }

    @Override
    public Activation convertToEntityAttribute(String value) {
        return Optional.ofNullable(value)
                .filter(each -> !each.isEmpty())
                .map(each -> {
                    try {
                        return Activation.valueOf(each);
                    } catch (Exception ex) {
                        log.error("Activation enum 轉型失敗 value：" + each);
                    }
                    return null;
                })
                .orElse(null);
    }
}

