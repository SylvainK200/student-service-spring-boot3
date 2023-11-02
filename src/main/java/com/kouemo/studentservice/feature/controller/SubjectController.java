package com.kouemo.studentservice.feature.controller;

import com.kouemo.studentservice.feature.dtos.SubjectRecord;
import com.kouemo.studentservice.feature.service.SubjectService;
import com.kouemo.studentservice.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/{id}")
    public ResponseEntity<SubjectRecord> findUserById(@PathVariable Long id){
        var subject = subjectService.findById(id);
        return ResponseEntity.ok(subject);
    }

    @GetMapping("")
    public ResponseEntity<Page<SubjectRecord>> findAllBySearch(
            @RequestParam(name="size",required = false,defaultValue = "10") String size,
            @RequestParam(name="page",required = false,defaultValue = "1") String page,
            @RequestParam(name="search",required = false, defaultValue = "") String search,
            @RequestParam(name="columnSort", required = false, defaultValue = "")String columnSort
    ){
        int sizePage = AppUtils.convertToInteger(size);
        int pageNumber= AppUtils.convertToInteger(page);
        var result = subjectService.findAllBySearch(pageNumber,sizePage,search,columnSort);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<SubjectRecord> create(@RequestBody SubjectRecord subject){
        return ResponseEntity.ok(subjectService.create(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectRecord> update(@PathVariable Long id,@RequestBody SubjectRecord updatedSubject){
        return ResponseEntity.ok(subjectService.update(updatedSubject,id));
    }

}
