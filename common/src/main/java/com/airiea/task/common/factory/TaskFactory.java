package com.airiea.task.common.factory;

import com.airiea.task.model.dao.TaskDAO;
import com.airiea.task.model.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskFactory {
    TaskFactory INSTANCE = Mappers.getMapper(TaskFactory.class);
    TaskDTO daoToDto(TaskDAO taskDAO);
    TaskDAO dtoToDao(TaskDTO taskDTO);
}
