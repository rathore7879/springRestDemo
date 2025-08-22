package exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private int status;
	private String message;
	private String details;
	private LocalDateTime date;
	
	public ErrorResponse(int status, String message, String details, LocalDateTime date) {
		super();
		this.status = status;
		this.message = message;
		this.details = details;
		this.date = date;
	}
	
	public ErrorResponse() {
		super();
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	

}
