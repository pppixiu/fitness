package com.nicebody.enums.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @ClassName OrderStatusSerializer
 * @Author sensu
 * @Date 2019/9/24 15:18
 **/
public class OnlineOrderStatusSerializer extends JsonSerializer<Integer> {
    /**
     * 转换状态码为状态
     *
     * @param integer
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(Integer integer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String status = "";
        switch (integer) {
            case 0:
                status = "未支付";
                break;
            case 1:
                status = "已支付";
                break;
            default:
                status = "转换失败";
        }
        jsonGenerator.writeString(status);
    }
}
