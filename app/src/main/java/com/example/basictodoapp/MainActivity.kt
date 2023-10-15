package com.example.basictodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private  lateinit var todoAdapter: ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = ToDoAdapter(mutableListOf())
        val rvTodo = findViewById<RecyclerView>(R.id.rvToDoItems)
        val btnAdd = findViewById<Button>(R.id.btnAddToDo)
        val btnDlt = findViewById<Button>(R.id.btnDltTodo)
        val edTodo = findViewById<EditText>(R.id.etToDoTitle)
        rvTodo.adapter  = todoAdapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener{
            val todoTitle = edTodo.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                edTodo.text.clear()
            }
        }

        btnDlt.setOnClickListener {
            todoAdapter.dltTodos()
        }
    }
}