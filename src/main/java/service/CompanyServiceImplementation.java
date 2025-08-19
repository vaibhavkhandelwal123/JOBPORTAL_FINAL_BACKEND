package service;

import dto.CompanyDTO;
import dto.UserDTO;
import entity.Company;
import exception.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CompanyRepository;
import utility.Utilities;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Long createCompanyProfile(UserDTO userDTO) throws Exception {
        Company company = new Company();
        company.setId(Utilities.getNextSequence("profiles"));
        company.setName(userDTO.getName());
        company.setEmail(userDTO.getEmail());
        company.setSpecialties(new ArrayList<>());
        companyRepository.save(company);
        return company.getId();
    }

    @Override
    public CompanyDTO updateCompany(CompanyDTO companyDTO) throws JobPortalException {
        if(!companyRepository.existsByName(companyDTO.getName())){
            throw new JobPortalException("Company not found");
        }
        Optional<Company> company = Optional.ofNullable(companyRepository.findIdByName(companyDTO.getName()));
        if(company.isPresent()){
            Company currCompany = company.get();
            currCompany.setName(companyDTO.getName());
            currCompany.setPictures(companyDTO.getPictures()!= null
                    ? Base64.getDecoder().decode(companyDTO.getPictures())
                    : null);
            currCompany.setIndustry(companyDTO.getIndustry());
            currCompany.setHeadQuarters(companyDTO.getHeadQuarters());
            currCompany.setSpecialties(companyDTO.getSpecialties());
            currCompany.setWebsite(companyDTO.getWebsite());
            currCompany.setSize(companyDTO.getSize());
            currCompany.setOverview(companyDTO.getOverview());
            currCompany.setIndustry(companyDTO.getIndustry());
            companyRepository.save(currCompany);
        }
        return companyDTO;
    }

    @Override
    public CompanyDTO getCompany(Long id) throws JobPortalException {
        return companyRepository.findById(id).orElseThrow(()->new JobPortalException("Company not found")).toDTO();
    }

    @Override
    public List<CompanyDTO> getAllCompany() throws JobPortalException {
        return companyRepository.findAll().stream().map(Company::toDTO).toList();
    }

}
