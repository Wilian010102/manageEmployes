package employes.manage_employes.controller;

import employes.manage_employes.entity.Employe;
import employes.manage_employes.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employes")
public class EmployeController {
    private final EmployeRepository employeRepository;
    @Autowired
    public EmployeController(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    // GET/employes - Retrieve all employes
    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    // GET/employes/{id} - Retrieve employe by id
    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        Optional<Employe> employe = employeRepository.findById((id));
        return employe.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // POST /employes - Create a new employee
    @PostMapping
    public Employe createEmploye(@RequestBody Employe employe) {
        return employeRepository.save(employe);
    }

    // DELETE /employes/{id} - Delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        if (employeRepository.existsById(id)) {
            employeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
