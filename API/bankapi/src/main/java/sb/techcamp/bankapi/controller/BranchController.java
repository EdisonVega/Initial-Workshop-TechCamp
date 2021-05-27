package sb.techcamp.bankapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sb.techcamp.bankapi.model.Branch;
import sb.techcamp.bankapi.service.old.BranchService;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchService branchService;


    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    // Get responses
    public ResponseEntity<List<Branch>>
}
