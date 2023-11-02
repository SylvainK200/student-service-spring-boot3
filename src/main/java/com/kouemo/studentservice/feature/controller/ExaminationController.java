package com.kouemo.studentservice.feature.controller;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.service.ExaminationService;
import com.kouemo.studentservice.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/examinations")
@RequiredArgsConstructor
public class ExaminationController {

    private final ExaminationService examinationService;

    @GetMapping("/{id}")
    public ResponseEntity<ExaminationRecord> findUserById(@PathVariable Long id){
        var examination = examinationService.findById(id);
        return ResponseEntity.ok(examination);
    }

    @GetMapping("")
    public ResponseEntity<Page<ExaminationRecord>> findAllBySearch(
            @RequestParam(name="size",required = false,defaultValue = "10") String size,
            @RequestParam(name="page",required = false,defaultValue = "1") String page,
            @RequestParam(name="search",required = false, defaultValue = "") String search,
            @RequestParam(name="columnSort", required = false, defaultValue = "")String columnSort
    ){
        int sizePage = AppUtils.convertToInteger(size);
        int pageNumber= AppUtils.convertToInteger(page);
        var result = examinationService.findAllBySearch(pageNumber,sizePage,search,columnSort);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<ExaminationRecord> create(@RequestBody ExaminationRecord examination){
        return ResponseEntity.ok(examinationService.create(examination));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExaminationRecord> update(@PathVariable Long id,@RequestBody ExaminationRecord updatedExamination){
        return ResponseEntity.ok(examinationService.update(updatedExamination,id));
    }

}
