package christian.alexandro.checklist.service;

import christian.alexandro.checklist.entity.ChecklistEntity;
import christian.alexandro.checklist.repository.ChecklistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteChecklistService {
    private final ChecklistRepository checklistRepository;

    public ResponseEntity<String> deleteChecklist(Long checklistId) {
        if(checklistId > 0){
            ChecklistEntity data = checklistRepository.findByIdAndActiveFlagTrue(checklistId).orElse(null);

            if(data == null){
                return new ResponseEntity<>("Penghapusan gagal", HttpStatus.BAD_REQUEST);
            }

            data.setActiveFlag(false);
            checklistRepository.save(data);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("Nama invalid", HttpStatus.BAD_REQUEST);
    }
}
