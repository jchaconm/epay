package com.itsight.epay.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSimpleDeserializer extends JsonDeserializer<Date> {

    private SimpleDateFormat formatterFull =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private SimpleDateFormat formatterOnlyDate =
            new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String dateAsString = jsonParser.getText();
        try {
            if (!StringUtils.hasText(dateAsString)) {
                return null;
            }
            if (dateAsString.length() > 10) {
                return formatterFull.parse(dateAsString);
            }
            return formatterOnlyDate.parse(dateAsString);
        } catch (ParseException pe) {
            throw new RuntimeException(pe);
        }
    }
}
