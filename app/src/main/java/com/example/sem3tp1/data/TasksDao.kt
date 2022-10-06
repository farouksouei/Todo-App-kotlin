package com.example.sem3tp1.data
import androidx.room.*

interface TasksDao {
    @Query("SELECT * FROM task_table")
    fun getAll(): List<Task>

    @Query("SELECT * FROM task_table WHERE id IN (:taskIds)")
    fun loadAllByIds(taskIds: IntArray): List<Task>

    @Query("SELECT * FROM task_table WHERE title LIKE :title LIMIT 1")
    fun findByTitle(title: String): Task

    @Insert
    fun insertAll(vararg tasks: Task)

    @Delete
    fun delete(task: Task)
    abstract fun insert(task: Task)
}