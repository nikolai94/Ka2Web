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
}