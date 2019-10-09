package com.itsight.epay.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSimpleSerializer extends JsonSerializer<Date> {

    private SimpleDateFormat formatterFull =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private SimpleDateFormat formatterOnlyDate =
            new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // TODO Auto-generated method stub
        if (value.toString().length() > 10) {
            jsonGenerator.writeString(formatterFull.format(value));
        } else {
            jsonGenerator.writeString(formatterOnlyDate.format(value));
        }
    }
}
