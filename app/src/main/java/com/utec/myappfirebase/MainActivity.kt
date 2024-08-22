package com.utec.myappfirebase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private val database = FirebaseDatabase.getInstance()
    private val databaseReference = database.reference.child("Usuario")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         editTextNombre = findViewById(R.id.editTextNombre)
         editTextApellido = findViewById(R.id.editTextApellido)
        var buttonRegistrar = findViewById<Button>(R.id.editbuttonRegistrar)

       buttonRegistrar.setOnClickListener {
           registrarUsuario()
       }
        }
    private fun registrarUsuario(){
        val usuario = Usuario(editTextNombre.text.toString(), editTextApellido.text.toString())
        val usuarioId = databaseReference.push().key
        databaseReference.child(usuarioId!!).setValue(usuario)
    }
}
data class Usuario(val nombre: String, val apellido: String)
