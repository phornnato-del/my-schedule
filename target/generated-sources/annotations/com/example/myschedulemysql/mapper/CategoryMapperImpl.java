package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.CategoryResDto;
import com.example.myschedulemysql.entity.CategoryEntity;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public List<CategoryResDto> category(List<CategoryEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CategoryResDto> list = new ArrayList<CategoryResDto>( entity.size() );
        for ( CategoryEntity categoryEntity : entity ) {
            list.add( categoryEntityToCategoryResDto( categoryEntity ) );
        }

        return list;
    }

    protected CategoryResDto categoryEntityToCategoryResDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryResDto categoryResDto = new CategoryResDto();

        categoryResDto.setDescription( categoryEntity.getDescription() );
        if ( categoryEntity.getId() != null ) {
            categoryResDto.setId( categoryEntity.getId().longValue() );
        }
        categoryResDto.setTitle( categoryEntity.getTitle() );
        categoryResDto.setType( categoryEntity.getType() );

        return categoryResDto;
    }
}
