package christian.alexandro.checklist.controller;

import christian.alexandro.checklist.dto.ChecklistRequest;
import christian.alexandro.checklist.entity.ChecklistEntity;
import christian.alexandro.checklist.service.AddChecklistService;
import christian.alexandro.checklist.service.ChecklistService;
import christian.alexandro.checklist.service.DeleteChecklistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/data")
public class ChecklistController {
    private final ChecklistService checklistService;
    private final AddChecklistService addChecklistService;
    private final DeleteChecklistService deleteChecklistService;

    @GetMapping("/checklist")
    public ResponseEntity<List<ChecklistEntity>> getAllChecklist(){
        return checklistService.findAllChecklist();
    }

    @PostMapping("/checklist")
    public ResponseEntity<String> newChecklist(@RequestBody ChecklistRequest checklist){
        return addChecklistService.addChecklist(checklist.getName());
    }

    @DeleteMapping("/checklist/{checklistId}")
    public ResponseEntity<String> removeChecklist(@PathVariable Long checklistId){
        return deleteChecklistService.deleteChecklist(checklistId);
    }

}
