package glassgiver.springproject.exceptions;

import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ValidationException extends RuntimeException {

    private List<String> errorsListMessages;

    public ValidationException(List<String> errorsListMessages) {
        super(errorsListMessages.stream().collect(Collectors.joining(", ")));
        this.errorsListMessages = errorsListMessages;
    }
}
