package com.example.myschedule.service.impl;

import com.example.myschedule.dao.GoalsDao;
import com.example.myschedule.dto.request.GoalsReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.GoalsResDto;
import com.example.myschedule.entity.GoalsEntity;
import com.example.myschedule.enums.StatusEnum;
import com.example.myschedule.mapper.GaolsMapper;
import com.example.myschedule.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoalServiceImp implements GoalService {

    private final GoalsDao goalsDao;
    private final GaolsMapper gaolsMapper;


    @Override
    public BaseWebResponse<GoalsResDto> insert(GoalsReqDto request) throws IOException {

        GoalsEntity goals = mapToEntity(request, null);
        goalsDao.saveEntity(goals);

        return BaseWebResponse.<GoalsResDto>builder()
               .status(StatusEnum.SUCCESS.getCode())
                .message("Goal created successfully !")
                .build();
    }

    @Override
    public BaseWebResponse<List<GoalsResDto>> getAllGoals() throws IOException {

        List<GoalsEntity> entity = goalsDao.findAll();
        List<GoalsResDto> data = gaolsMapper.toDto(entity);

        return BaseWebResponse.<List<GoalsResDto>>builder()
               .status(StatusEnum.SUCCESS.getCode())
                .message("Retrieved Goal successfully !")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<GoalsResDto> getAllGoalsById(Long id) throws IOException {

        GoalsEntity entity = goalsDao.findById(id)
                .orElseThrow(() -> new RuntimeException(" Goal not found with id: " + id));

        GoalsResDto data = gaolsMapper.getByIntoDto(entity);

        return BaseWebResponse.<GoalsResDto>builder()
               .status(StatusEnum.SUCCESS.getCode())
                .message("Retrieved Goal successfully !")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<GoalsResDto> update(Long id, GoalsReqDto request) throws IOException {
        GoalsEntity goals = mapToEntity(request, id);
        goalsDao.saveEntity(goals);

        return BaseWebResponse.<GoalsResDto>builder()
               .status(StatusEnum.SUCCESS.getCode())
                .message("Goal updated successfully !")
                .build();
    }

    @Override
    public BaseWebResponse<Void> delete(Long id) throws IOException {
        GoalsEntity entity = goalsDao.findById(id)
                .orElseThrow(() -> new RuntimeException(" Goal not found with id: " + id));

        goalsDao.deleteById(id);

        return BaseWebResponse.<Void>builder()
               .status(StatusEnum.SUCCESS.getCode())
                .message("Goal deleted successfully !")
                .build();

    }

    private GoalsEntity mapToEntity(GoalsReqDto request, Long id){
        GoalsEntity goals = Objects.nonNull(id)
                ? goalsDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal not found with id: " + id))
                : new GoalsEntity();

        goals.setUserId(request.getUserId());
        goals.setTitle(request.getTitle());
        goals.setDescription(request.getDescription());
        goals.setCategoryId(request.getCategoryId());
        goals.setStartDate(request.getStartDate());
        goals.setTargetDate(request.getTargetDate());
        goals.setPriorityId(request.getPriorityId());
        goals.setStatusId(request.getStatusId());
        goals.setProgress(request.getProgress());

        if(Objects.isNull(id)){
            goals.setCreatedAt(LocalDate.now());
        }else {
            goals.setUpdatedAt(LocalDate.now());
        }

        return goals;
    }
}
