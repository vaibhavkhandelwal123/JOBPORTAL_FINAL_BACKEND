package repository;

import entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company,Long> {
    boolean existsByName(String company);
    Company findIdByName(String company);
}
