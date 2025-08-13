package api;

import dto.CompanyDTO;
import dto.ProfileDTO;
import exception.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CompanyService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyAPI {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/get/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable Long id) throws JobPortalException {
        return new ResponseEntity<>(companyService.getCompany(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CompanyDTO>updateCompany(@RequestBody CompanyDTO companyDTO)throws JobPortalException{
        return new ResponseEntity<>(companyService.updateCompany(companyDTO),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyDTO>>getAllCompany() throws JobPortalException{
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }
}
