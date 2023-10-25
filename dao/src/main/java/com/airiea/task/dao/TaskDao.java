package com.airiea.task.dao;

import com.airiea.task.model.dto.Task;

import java.util.List;

/**
 * Data Access Object (DAO) interface for tasks.
 * This provides methods to perform operations on tasks.
 */
public interface TaskDao {
    /**
     * Retrieve a task by its unique identifier.
     *
     * @param taskId The unique identifier of the task.
     * @return The task associated with the given ID, or null if not found.
     */
    Task getTaskById(String taskId);

    /**
     * Retrieve a list of tasks associated with a specific entity.
     *
     * @param entityId The ID of the entity.
     * @return A list of tasks associated with the given entity ID.
     */
    List<Task> getTasksByEntityId(String entityId);
}
