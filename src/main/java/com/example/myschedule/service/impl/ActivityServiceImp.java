package com.example.myschedule.service.impl;

import com.example.myschedule.dao.ActivitiesDao;
import com.example.myschedule.dto.request.ActivitiesReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.ActivitiesResDto;
import com.example.myschedule.entity.ActivitiesEntity;
import com.example.myschedule.enums.StatusEnum;
import com.example.myschedule.exception.ApiException;
import com.example.myschedule.mapper.ActivityMapper;
import com.example.myschedule.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ActivityServiceImp implements ActivityService {

    private final ActivitiesDao activityService;
    private final ActivityMapper activityMapper;

    @Override
    public BaseWebResponse<ActivitiesResDto> insert(ActivitiesReqDto request) throws IOException {

       try{
           ActivitiesEntity goals = mapToEntity(request, null);
           activityService.saveEntity(goals);

           return BaseWebResponse.<ActivitiesResDto>builder()
                   .status(StatusEnum.SUCCESS.getCode())
                   .message("Activity created successfully !")
                   .build();
       }catch (ApiException e){
           throw e;
       }catch(Exception e){
           throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
       }
    }

    @Override
    public BaseWebResponse<List<ActivitiesResDto>> getAllActivities() throws IOException {

        try{
            List<ActivitiesEntity> entity = activityService.findAll();
            List<ActivitiesResDto> data = activityMapper.toDto(entity);

            return BaseWebResponse.<List<ActivitiesResDto>>builder()
                    .status(StatusEnum.SUCCESS.getCode())
                    .message("Retrieved Activity successfully !")
                    .data(data)
                    .build();
        }catch (ApiException e){
            throw e;
        }catch(Exception e){
            throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @Override
    public BaseWebResponse<ActivitiesResDto> getAllActivityById(Long id) throws IOException {

        try {
            ActivitiesEntity entity = activityService.findById(id)
                    .orElseThrow(() -> new ApiException(StatusEnum.NOT_FOUND.getCode(), "Activity not found " + id));

            ActivitiesResDto data = activityMapper.getByIntoDto(entity);

            return BaseWebResponse.<ActivitiesResDto>builder()
                    .status(StatusEnum.SUCCESS.getCode())
                    .message("Retrieved Activity successfully !")
                    .data(data)
                    .build();
        }catch (ApiException e){
            throw e;
        }
        catch (Exception e){
            throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @Override
    public BaseWebResponse<ActivitiesResDto> update(Long id, ActivitiesReqDto request) throws IOException {
        try{
            ActivitiesEntity goals = mapToEntity(request, id);
            activityService.saveEntity(goals);

            return BaseWebResponse.<ActivitiesResDto>builder()
                    .status(StatusEnum.SUCCESS.getCode())
                    .message("Activity updated successfully !")
                    .build();

        }catch (ApiException e){
            throw e;
        }catch (Exception e){
                throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
            }
        }

    @Override
    public BaseWebResponse<Void> delete(Long id) throws IOException {
        try {
            ActivitiesEntity entity = activityService.findById(id)
                    .orElseThrow(() ->  new ApiException(StatusEnum.NOT_FOUND.getCode(), "Activity not found " + id));

            activityService.deleteById(id);

            return BaseWebResponse.<Void>builder()
                    .status(StatusEnum.SUCCESS.getCode())
                    .message("Activity deleted successfully !")
                    .build();
        }catch (ApiException e){
            throw e;
        }catch (Exception e){
            throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }

    }

    private ActivitiesEntity mapToEntity(ActivitiesReqDto request, Long id){
        try{
            ActivitiesEntity activity = Objects.nonNull(id)
                    ? activityService.findById(id)
                    .orElseThrow(() ->  new ApiException(StatusEnum.NOT_FOUND.getCode(), "Activite not found " + id))
                    : new ActivitiesEntity();

            activity.setUserId(request.getUserId());
            activity.setActivityName(request.getActivityName());
            activity.setCategoryId(request.getCategoryId());
            activity.setDurationMinutes(request.getDurationMinutes());
            activity.setActivityDate(request.getActivityDate());
            activity.setNote(request.getNote());

            if(Objects.isNull(id)){
                activity.setCreatedAt(LocalDate.now());
            }

            return activity;
        }catch (ApiException e){
            throw e;
        }catch (Exception e){
            throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }
    }
}
