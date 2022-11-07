package com.project.cinematicket.mapper;

import com.project.cinematicket.dto.UserDTO;
import com.project.cinematicket.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDTO mapEntityToDTO(UserEntity userEntity);

    UserEntity mapDTOtoEntity(UserDTO userDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "surname", ignore = true)
    void updateUserMoney(@MappingTarget UserEntity userEntity, UserDTO userDTO);

    List<UserDTO> mapToDTOList(List<UserEntity> userEntities);
}
