package site.metacoding.instagram.handler.ex;

public class CustomException extends RuntimeException {

    // 객체를 구분할때 사용 (JVM)
    private static final long serialVersionUID = 1L;

    public CustomException(String message) {
        super(message);
    }
}
