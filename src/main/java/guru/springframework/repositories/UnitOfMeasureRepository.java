package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	// QueryMethods
	Optional<UnitOfMeasure> findByDescription(String description);
}
