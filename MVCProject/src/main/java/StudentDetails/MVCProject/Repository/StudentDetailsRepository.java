package StudentDetails.MVCProject.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import StudentDetails.MVCProject.Entity.Student;

@Repository
public interface StudentDetailsRepository extends JpaRepository<Student, Long>{

	

}
