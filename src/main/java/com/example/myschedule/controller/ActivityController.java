package com.example.myschedule.controller;

import com.example.myschedule.dto.request.ActivitiesReqDto;

import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.ActivitiesResDto;
import com.example.myschedule.service.ActivityService;
import com.example.myschedule.service.crypto.Encrypted;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
@RequiredArgsConstructor
//@Encrypted
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public BaseWebResponse<List<ActivitiesResDto>> getAllActivities() throws IOException{
        return activityService.getAllActivities();
    }

    @GetMapping("/{id}")
    public BaseWebResponse<ActivitiesResDto> getAllActivityById(@PathVariable Long id) throws IOException{
        return activityService.getAllActivityById(id);
    }

    @PostMapping
    public BaseWebResponse<ActivitiesResDto> insert(@RequestBody ActivitiesReqDto request) throws IOException {
        return activityService.insert(request);
    }

    @PostMapping("/update/{id}")
    public  BaseWebResponse<ActivitiesResDto> update(@PathVariable Long id, @RequestBody ActivitiesReqDto request) throws IOException{
        return activityService.update(id, request);
    }

    @PostMapping("/delete/{id}")
    public  BaseWebResponse<Void> delete(@PathVariable Long id) throws IOException{
        return activityService.delete(id);
    }

}