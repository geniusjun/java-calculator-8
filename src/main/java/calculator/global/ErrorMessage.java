package calculator.global;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    INVALID_LINEFEED("커스텀 구분자 지정 형식이 잘못되었습니다."),
    INVALID_CUSTOM_DELIMITER("커스텀 구분자는 길이가 1인 문자여야 합니다."),
    EMPTY_TOKEN_ERROR("구분자 사이는 비어있으면 안됩니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력할 수 있습니다."),
    INVALID_NUMBER_POSITIVE("숫자는 양수만 들어올 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
