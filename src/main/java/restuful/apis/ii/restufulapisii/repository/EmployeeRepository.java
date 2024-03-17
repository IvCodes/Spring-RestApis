package restuful.apis.ii.restufulapisii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restuful.apis.ii.restufulapisii.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    


}
