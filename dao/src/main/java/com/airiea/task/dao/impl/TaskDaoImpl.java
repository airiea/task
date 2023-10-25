package com.airiea.task.dao.impl;

import com.airiea.task.dao.TaskDao;
import com.airiea.task.common.factory.TaskFactory;
import com.airiea.task.model.orm.TaskRecord;
import com.airiea.task.model.dto.Task;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskDaoImpl implements TaskDao {
    private static final String INDEX_NAME = "entity_id-agent_name";

    private final DynamoDBMapper dynamoDBMapper;
    private final TaskFactory taskFactory;

    /**
     * Constructor for TaskDaoImpl.
     *
     * @param dynamoDBMapper The DynamoDBMapper to interact with the database.
     */
    public TaskDaoImpl(final DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = Objects.requireNonNull(dynamoDBMapper, "Mapper cannot be null");
        this.taskFactory = TaskFactory.INSTANCE;
    }

    /**
     * Retrieve a Task by its ID.
     *
     * @param taskId The ID of the task.
     * @return The Task object.
     */
    @Override
    public Task getTaskById(String taskId) {
        final TaskRecord taskRecord = dynamoDBMapper.load(TaskRecord.class, taskId);
        return Optional.ofNullable(taskRecord)
                .map(taskFactory::taskRecordToTask)
                .orElse(null);
    }

    /**
     * Retrieve a list of Tasks by their entity ID.
     *
     * @param entityId The entity ID associated with the tasks.
     * @return A list of Task objects.
     */
    @Override
    public List<Task> getTasksByEntityId(String entityId) {
        TaskRecord gsiKeys = new TaskRecord();
        gsiKeys.setEntityId(entityId);

        DynamoDBQueryExpression<TaskRecord> queryExpression = new DynamoDBQueryExpression<TaskRecord>()
                .withIndexName(INDEX_NAME)
                .withHashKeyValues(gsiKeys)
                .withConsistentRead(false);

        final List<TaskRecord> taskRecordList = dynamoDBMapper.query(TaskRecord.class, queryExpression);

        return taskRecordList.stream()
                .map(taskFactory::taskRecordToTask)
                .collect(Collectors.toList());
    }

}
