package primertrabajo.arqui.demo.api;

import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import primertrabajo.arqui.demo.bl.CurrencyBl;
import primertrabajo.arqui.demo.dto.ApiDto;
import primertrabajo.arqui.demo.dto.ResponseDto;

import java.math.BigDecimal;
@RestController
@RequestMapping("v1/change")
public class Api {

    private CurrencyBl currencyBl;

    public Api(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    @GetMapping("/coin")
    public ResponseEntity<ResponseDto<ApiDto>> getChange(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) throws Exception {
        ApiDto apiDto = currencyBl.getExchange(from, to, amount);
        ResponseDto<ApiDto> responseDto = new ResponseDto<ApiDto>(true, apiDto, "Success");
        return ResponseEntity.ok(responseDto);
    }
}
