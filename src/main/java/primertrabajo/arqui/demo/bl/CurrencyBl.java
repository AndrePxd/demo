package primertrabajo.arqui.demo.bl;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import primertrabajo.arqui.demo.dto.ApiDto;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class CurrencyBl {
    public ApiDto getExchange (String from, String to, BigDecimal amount)throws IOException {
        if(amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to="+to +"& from=" +from+"& amount="+ amount)
                .addHeader("apikey", "HhvYSUHpiQWsUZ79MC3FTHd2TdD0R6g3")
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        System.out.println(responseBody);


        ObjectMapper objectMapper = new ObjectMapper();
        ApiDto apiDto = objectMapper.readValue(responseBody, ApiDto.class);
        return apiDto;
    }

}
