package site.metacoding.instagram.handler.ex;

public class CustomApiException extends RuntimeException {

    // 객체를 구분할때 사용 (JVM)
    private static final long serialVersionUID = 1L;


    public CustomApiException(String message) {
        super(message);
    }
 }          

