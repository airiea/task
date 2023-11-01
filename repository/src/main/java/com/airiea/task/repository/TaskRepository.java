package com.airiea.task.repository;

import com.airiea.task.model.dao.TaskDAO;
import com.airiea.task.model.dto.TaskDTO;

import java.util.List;

/**
 * Data Access Object (DAO) interface for tasks.
 * This provides methods to perform operations on tasks.
 */
public interface TaskRepository {
    /**
     * Retrieve a task by its unique identifier.
     *
     * @param taskId The unique identifier of the task.
     * @return The task associated with the given ID, or null if not found.
     */
    TaskDTO getTaskDTOById(String taskId);

    /**
     * Retrieve a list of tasks associated with a specific entity.
     *
     * @param entityId The ID of the entity.
     * @return A list of tasks associated with the given entity ID.
     */
    List<TaskDTO> getTaskDTOsByEntityId(String entityId);

    TaskDAO getTaskDAOById(String taskId);
    TaskDAO createTaskDAO(TaskDAO taskDAO);
    TaskDAO updateTaskDAO(TaskDAO taskDAO);
    List<TaskDAO> getTaskDAOsByEntityId(String entityId);
}
