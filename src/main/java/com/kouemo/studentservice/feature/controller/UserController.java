package com.kouemo.studentservice.feature.controller;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.UserRecord;
import com.kouemo.studentservice.feature.service.ExaminationService;
import com.kouemo.studentservice.feature.service.UserService;
import com.kouemo.studentservice.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserRecord> findUserById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("")
    public ResponseEntity<Page<UserRecord>> findAllBySearch(
            @RequestParam(name="size",required = false,defaultValue = "10") String size,
            @RequestParam(name="page",required = false,defaultValue = "1") String page,
            @RequestParam(name="search",required = false, defaultValue = "") String search,
            @RequestParam(name="columnSort", required = false, defaultValue = "")String columnSort
    ){
        int sizePage = AppUtils.convertToInteger(size);
        int pageNumber= AppUtils.convertToInteger(page);
        var result = userService.findAllBySearch(pageNumber,sizePage,search,columnSort);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<UserRecord> create(@RequestBody UserRecord user){
        return ResponseEntity.ok(userService.create(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRecord> update(@PathVariable Long id,@RequestBody UserRecord updatedUser){
        return ResponseEntity.ok(userService.update(updatedUser,id));
    }

}
