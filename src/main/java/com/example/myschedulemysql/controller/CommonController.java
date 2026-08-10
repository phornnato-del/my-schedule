package com.example.myschedulemysql.controller;

import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.CategoryResDto;
import com.example.myschedulemysql.dto.response.PriorityResDto;
import com.example.myschedulemysql.dto.response.StatusResDto;
import com.example.myschedulemysql.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/common")
@RequiredArgsConstructor
public class CommonController {

    private final CommonService statusService;

    @GetMapping("/status")
    public BaseWebResponse<List<StatusResDto>> getStatus() throws IOException{
        return statusService.getStatus();
    }

    @GetMapping("/priority")
    public BaseWebResponse<List<PriorityResDto>> getPriority() throws IOException{
        return statusService.getPriority();
    }

    @GetMapping("/category")
    public BaseWebResponse<List<CategoryResDto>> getCategories(@RequestParam(required = false) String type) throws IOException{
        return statusService.getCategories(type);
    }

}
