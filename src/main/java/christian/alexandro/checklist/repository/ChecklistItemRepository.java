package christian.alexandro.checklist.repository;

import christian.alexandro.checklist.entity.ChecklistItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChecklistItemRepository extends JpaRepository<ChecklistItemEntity, Long> {

    Optional<Object> findByItemNameAndChecklistIdAndActiveFlagTrue(String name, Long checklistId);

    List<ChecklistItemEntity> findAllByChecklistIdAndActiveFlagTrue(Long checklistId);

    Optional<ChecklistItemEntity> findByChecklistIdAndIdAndActiveFlagTrue(Long checklistId, Long checklistItemId);

    Optional<ChecklistItemEntity> findByChecklistIdAndItemNameAndActiveFlagTrue(Long checklistId, String name);

}
