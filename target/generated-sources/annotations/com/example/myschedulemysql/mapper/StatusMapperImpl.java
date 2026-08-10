package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.StatusResDto;
import com.example.myschedulemysql.entity.StatusEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-10T23:21:15+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.100.v20260624-0231, environment: Java 21.0.11 (Eclipse Adoptium)"
)
@Component
public class StatusMapperImpl implements StatusMapper {

    @Override
    public List<StatusResDto> status(List<StatusEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<StatusResDto> list = new ArrayList<StatusResDto>( entity.size() );
        for ( StatusEntity statusEntity : entity ) {
            list.add( statusEntityToStatusResDto( statusEntity ) );
        }

        return list;
    }

    protected StatusResDto statusEntityToStatusResDto(StatusEntity statusEntity) {
        if ( statusEntity == null ) {
            return null;
        }

        StatusResDto statusResDto = new StatusResDto();

        statusResDto.setDescription( statusEntity.getDescription() );
        statusResDto.setId( statusEntity.getId() );
        statusResDto.setTitle( statusEntity.getTitle() );

        return statusResDto;
    }
}
