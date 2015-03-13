package exceptions;
import java.io.PrintWriter;
import java.io.StringWriter;
public class ErrorMessage {

    public ErrorMessage(Throwable ex, int code,boolean debug) {
    this.code = code;
    this.message = ex.getMessage();
    this.description = ex.getMessage();
    
    if(debug){
    StringWriter sw = new StringWriter();
    ex.printStackTrace(new PrintWriter(sw));
    this.stackTrace = sw.toString();
    }

}
    
    private int code;
    private String message;
    private String description;
    private String stackTrace;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public String getStackTrace() {
        return stackTrace;
    }


}