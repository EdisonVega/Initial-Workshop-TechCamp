package sb.techcamp.bankapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.techcamp.bankapi.model.Branch;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    Optional<Branch> findBranchByBranchId(Long id);
    Optional<Branch> findBranchByBranchName(String name);

    void deleteBranchByBranchId(Long id);
}
