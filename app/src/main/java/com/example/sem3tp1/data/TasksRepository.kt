package com.example.sem3tp1.data

class TasksRepository(private val tasksDao: TasksDao) {
    val allTasks = tasksDao.getAll()

    fun insert(task: Task) {
        tasksDao.insert(task)
    }

    fun delete(task: Task) {
        tasksDao.delete(task)
    }
}
