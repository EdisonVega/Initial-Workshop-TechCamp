package sb.techcamp.bankapi.dto.repository;

import sb.techcamp.bankapi.dto.BranchDTO;


import java.util.List;
import java.util.Optional;


public interface BranchDTORepo {

    List<BranchDTO> getAll();
    Optional<BranchDTO> getById(Long id);
    Optional<BranchDTO> getByName(String name);

    BranchDTO add(BranchDTO branchDTO);
    BranchDTO update(BranchDTO branchDTO);

    void delete(Long id);

}
