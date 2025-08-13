package service;

import dto.CompanyDTO;
import dto.UserDTO;
import exception.JobPortalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    public Long createCompanyProfile(UserDTO userDTO) throws Exception;
    public CompanyDTO getCompany(Long id) throws JobPortalException;
    public List<CompanyDTO> getAllCompany() throws JobPortalException;
    public CompanyDTO updateCompany(CompanyDTO companyDTO) throws JobPortalException;
}
