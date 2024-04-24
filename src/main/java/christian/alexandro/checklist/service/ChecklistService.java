package christian.alexandro.checklist.service;

import christian.alexandro.checklist.entity.ChecklistEntity;
import christian.alexandro.checklist.repository.ChecklistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChecklistService {
    private final ChecklistRepository checklistRepository;

    public ResponseEntity<List<ChecklistEntity>> findAllChecklist() {
        List<ChecklistEntity> allPhonebook = checklistRepository.findAllByActiveFlagTrue();
        return new ResponseEntity<>(allPhonebook, HttpStatus.OK);
    }
}
