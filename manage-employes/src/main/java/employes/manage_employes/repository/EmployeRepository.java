package employes.manage_employes.repository;

import employes.manage_employes.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
