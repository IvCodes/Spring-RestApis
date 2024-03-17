package restuful.apis.ii.restufulapisii.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id){

        super("could not find employee "+ id);



    }

}
