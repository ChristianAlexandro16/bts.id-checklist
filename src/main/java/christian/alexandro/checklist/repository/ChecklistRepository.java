package christian.alexandro.checklist.repository;

import christian.alexandro.checklist.entity.ChecklistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChecklistRepository extends JpaRepository<ChecklistEntity, Long> {

    Optional<Object> findByNameAndActiveFlagTrue(String name);

    Optional<ChecklistEntity> findByIdAndActiveFlagTrue(Long checklistId);

    List<ChecklistEntity> findAllByActiveFlagTrue();
}
