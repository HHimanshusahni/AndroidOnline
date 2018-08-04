package com.online.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.online.todolist.db.MyDbHelper
import com.online.todolist.db.Todo
import com.online.todolist.db.TodoTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val todos = ArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoAdpater = ArrayAdapter<Todo>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                todos
        )

        val db = MyDbHelper(this).writableDatabase // writableDatabase  puts the lock on the database use it judiciously (when doing read and write operations)


        fun refreshTodoList( ){
          val todoList =   TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdpater.notifyDataSetChanged()
            Log.d("TODOS",todoList.toString())
        }
        lvTodos.adapter = todoAdpater
        refreshTodoList()

        btnAddTodo.setOnClickListener{
              val newTodo = Todo(
                etNewTodo.text.toString(),
                false
              )
            TodoTable.insertTodo(db,newTodo)
            refreshTodoList()

        }
    }

}
