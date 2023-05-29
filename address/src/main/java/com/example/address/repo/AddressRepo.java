package com.example.address.repo;

import com.example.address.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<AddressEntity,Integer> {
//@Query(nativeQuery = true, value = "SELECT * FROM address_db.address_entity a join address_db.employee_entity e on a.employee_id=e.id where a.employee_id=?")
@Query(nativeQuery = true, value="select a.* from address_entity as a inner join employee_entity as e on a.employee_id=e.id where a.employee_id=?")

AddressEntity findAddressByEmployeeAddress(@Param("employee_id") int employeeId);  //whenever you call the method and provide the value of employeeId as parameter
}
