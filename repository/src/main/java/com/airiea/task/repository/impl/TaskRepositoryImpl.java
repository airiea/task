package com.airiea.task.repository.impl;

import com.airiea.task.common.factory.TaskFactory;
import com.airiea.task.model.dao.TaskDAO;
import com.airiea.task.model.dto.TaskDTO;
import com.airiea.task.repository.TaskRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskRepositoryImpl implements TaskRepository {
    private static final String INDEX_NAME = "entity_id-agent_name";

    private final DynamoDBMapper dynamoDBMapper;
    private final TaskFactory taskFactory;

    /**
     * Constructor for TaskDaoImpl.
     *
     * @param dynamoDBMapper The DynamoDBMapper to interact with the database.
     */
    public TaskRepositoryImpl(final DynamoDBMapper dynamoDBMapper) {
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
    public TaskDTO getTaskDTOById(String taskId) {
        final TaskDAO taskDAO = this.getTaskDAOById(taskId);

        return Optional.ofNullable(taskDAO)
                .map(taskFactory::daoToDto)
                .orElse(null);
    }

    /**
     * Retrieve a list of Tasks by their entity ID.
     *
     * @param entityId The entity ID associated with the tasks.
     * @return A list of Task objects.
     */
    @Override
    public List<TaskDTO> getTaskDTOsByEntityId(String entityId) {
        final List<TaskDAO> taskDAOList = this.getTaskDAOsByEntityId(entityId);

        return taskDAOList.stream()
                .map(taskFactory::daoToDto)
                .collect(Collectors.toList());
    }



    @Override
    public TaskDAO getTaskDAOById(String taskId) {
        return dynamoDBMapper.load(TaskDAO.class, taskId);
    }

    @Override
    public TaskDAO createTaskDAO(TaskDAO taskDAO) {
        if (!Objects.isNull(dynamoDBMapper.load(taskDAO))) {
            throw new IllegalArgumentException("Failed to create taskDAO " + taskDAO + ", item already exists.");
        }

        dynamoDBMapper.save(taskDAO);
        return taskDAO;
    }

    @Override
    public TaskDAO updateTaskDAO(TaskDAO taskDAO) {
        if (Objects.isNull(dynamoDBMapper.load(taskDAO))) {
            throw new IllegalArgumentException("Failed to update taskDAO " + taskDAO + ", item not found.");
        }

        dynamoDBMapper.save(taskDAO);
        return taskDAO;
    }

    @Override
    public List<TaskDAO> getTaskDAOsByEntityId(String entityId) {
        TaskDAO gsiKeys = new TaskDAO();
        gsiKeys.setAgentName(entityId);

        DynamoDBQueryExpression<TaskDAO> queryExpression = new DynamoDBQueryExpression<TaskDAO>()
                .withIndexName(INDEX_NAME)
                .withHashKeyValues(gsiKeys)
                .withConsistentRead(false);

        return dynamoDBMapper.query(TaskDAO.class, queryExpression);
    }

}
