package istPay.example.vagasistPay.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class ApiErrors {

    private List<String> errors;

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String mensagemErro) {
        this.errors = Arrays.asList(mensagemErro);
    }
}
