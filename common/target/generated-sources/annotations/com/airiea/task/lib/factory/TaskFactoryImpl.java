package com.airiea.task.lib.factory;

import com.airiea.task.common.factory.TaskFactory;
import com.airiea.task.model.dto.Task;
import com.airiea.task.model.orm.TaskRecord;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-25T00:47:44-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
*/
public class TaskFactoryImpl implements TaskFactory {

    @Override
    public Task taskRecordToTask(TaskRecord taskRecord) {
        if ( taskRecord == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.taskId( taskRecord.getTaskId() );
        task.knowledgeId( taskRecord.getKnowledgeId() );
        task.entityId( taskRecord.getEntityId() );
        task.agentName( taskRecord.getAgentName() );
        task.taskCount( taskRecord.getTaskCount() );
        task.prompt( taskRecord.getPrompt() );
        task.content( taskRecord.getContent() );
        task.statusCode( taskRecord.getStatusCode() );
        task.errorCode( taskRecord.getErrorCode() );
        task.errorMessage( taskRecord.getErrorMessage() );
        task.createdDate( taskRecord.getCreatedDate() );
        task.updatedDate( taskRecord.getUpdatedDate() );

        return task.build();
    }

    @Override
    public TaskRecord taskToTaskRecord(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskRecord.TaskRecordBuilder taskRecord = TaskRecord.builder();

        taskRecord.taskId( task.getTaskId() );
        taskRecord.knowledgeId( task.getKnowledgeId() );
        taskRecord.entityId( task.getEntityId() );
        taskRecord.agentName( task.getAgentName() );
        taskRecord.taskCount( task.getTaskCount() );
        taskRecord.prompt( task.getPrompt() );
        taskRecord.content( task.getContent() );
        taskRecord.statusCode( task.getStatusCode() );
        taskRecord.errorCode( task.getErrorCode() );
        taskRecord.errorMessage( task.getErrorMessage() );
        taskRecord.createdDate( task.getCreatedDate() );
        taskRecord.updatedDate( task.getUpdatedDate() );

        return taskRecord.build();
    }
}
