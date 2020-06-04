package cs425.eRegistrar.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs425.eRegistrar.Api.model.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
    @Query("SELECT s FROM Student s WHERE CONCAT(s.id, ' '" +
            ", s.studentNumber,' '" +
            ",s.firstName,' '" +
            ",s.middleName,' '" +
            ",s.lastName,' '," +
            "s.cgpa,' '," +
            "s.dateOfEnrollment,' '," +
            "s.isInternational,' ' ) LIKE CONCAT('%', :search, '%')")
    List<Student> searchStudents(@Param("search") String search);

}
