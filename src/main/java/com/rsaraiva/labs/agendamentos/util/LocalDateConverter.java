package com.rsaraiva.labs.agendamentos.util;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.faces.bean.RequestScoped;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;

@Convert(LocalDate.class)
@RequestScoped
public class LocalDateConverter implements Converter<LocalDate> {

    @Override
    public LocalDate convert(String value, Class<? extends LocalDate> type) {
        if (isNullOrEmpty(value)) {
            return null;
        }
        try {
            return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e1) {
            try {
                return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e2) {
                throw new ConversionException(new ConversionMessage("is_not_a_valid_date", value));
            }
        }
    }
}
