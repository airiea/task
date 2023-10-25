package com.airiea.task.common.factory;

import com.airiea.task.model.dto.Task;
import com.airiea.task.model.orm.TaskRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskFactory {
    TaskFactory INSTANCE = Mappers.getMapper(TaskFactory.class);
    Task taskRecordToTask(TaskRecord taskRecord);
    TaskRecord taskToTaskRecord(Task task);
}
