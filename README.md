# SpringBootExceptionHandling
This demo shows the GlobalHandlerException and Custom Exception and user of @ControllerAdvice

## Endpoint Details:
```
GET     http://localhost:8080/api/employee/5
```
* Without having any custom exception handling class, Spring Boot provides default structure of Exception Handling Class.
```JSON
{
    "timestamp": "2021-11-27T16:34:00.445+00:00",
    "status": 404,
    "error": "Not Found",
    "path": "/api/employee/5"
}
```
But sometimes we need to update the error response format based on business logic. Let's say:
```JSON
{
    "cause": null,
    "timestamp": "2021-11-27T16:48:16.481+00:00",
    "message": "Employee not present : 5",
    "details": "uri=/api/employee/5",
    "suppressed": [],
    "localizedMessage": "Employee not present : 5"
}
```
* For this we have created custom exception class i.e. ResourceNotFoundException.
* GlobalExceptionHandler is created which needs to be annotated with **@ControllerAdvice**
* Method is annotated with **@ExceptionHandler**
```Java
// Handling Specific Exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
```