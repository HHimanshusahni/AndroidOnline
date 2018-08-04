package com.online.todolist.db

data class Todo(var task:String,var done:Boolean){
    override fun toString(): String {
        return this.task
    }
}
