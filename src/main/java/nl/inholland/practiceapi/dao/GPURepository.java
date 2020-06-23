package nl.inholland.practiceapi.dao;

import nl.inholland.practiceapi.model.GPU;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPURepository extends CrudRepository<GPU, Long> {
}
