package calculator.global;

public enum ErrorMessage {
    INVALID_POSITIVE_NUMBER("숫자들은 양수여야 합니다");

    private static final String PREFIX = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
