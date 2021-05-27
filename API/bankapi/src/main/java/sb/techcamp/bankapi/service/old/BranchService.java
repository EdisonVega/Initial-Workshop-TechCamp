package sb.techcamp.bankapi.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.techcamp.bankapi.exception.UserNotFoundException;
import sb.techcamp.bankapi.model.Branch;
import sb.techcamp.bankapi.model.repository.BranchRepository;

import java.util.List;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    // Find methods
    public List<Branch> findAllBranch(){
        return branchRepository.findAll();
    }

    public Branch findBranchById(Long branchId){
        return branchRepository.findBranchByBranchId(branchId).
                orElseThrow(() -> new UserNotFoundException("Branch with id " + branchId + " was not found"));
    }

    public Branch findByName(String name){
        return branchRepository.findBranchByBranchName(name).
                orElseThrow(() -> new UserNotFoundException("Branch with name " + name + " was not found"));
    }

    // Add methods
    public Branch addBranch(Branch branch){
        return branchRepository.save(branch);
    }

    // Update methods
    public Branch updateBranch(Branch branch){
        return branchRepository.save(branch);
    }

    // Delete methods
    public void deleteBranch(long branchId){
        branchRepository.deleteBranchByBranchId(branchId);
    }
}
