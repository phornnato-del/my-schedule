package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.PriorityResDto;
import com.example.myschedulemysql.entity.PriorityEntity;
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
public class PriorityMapperImpl implements PriorityMapper {

    @Override
    public List<PriorityResDto> priority(List<PriorityEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<PriorityResDto> list = new ArrayList<PriorityResDto>( entity.size() );
        for ( PriorityEntity priorityEntity : entity ) {
            list.add( priorityEntityToPriorityResDto( priorityEntity ) );
        }

        return list;
    }

    protected PriorityResDto priorityEntityToPriorityResDto(PriorityEntity priorityEntity) {
        if ( priorityEntity == null ) {
            return null;
        }

        PriorityResDto priorityResDto = new PriorityResDto();

        priorityResDto.setDescription( priorityEntity.getDescription() );
        priorityResDto.setId( priorityEntity.getId() );
        priorityResDto.setTitle( priorityEntity.getTitle() );

        return priorityResDto;
    }
}
