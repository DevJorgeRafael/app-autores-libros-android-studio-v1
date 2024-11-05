package com.example.apputnsqlite;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtId ,txtNombres, txtApellidos, txtIsoPais, txtEdad;
    Autores lsAutores;
    Libros lsLibros;
    TextView lblUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //listaAutores = new Autores(this, "biblioteca.db", 1);
        //Autor r = listaAutores.Create(1, "Amado", "Nervo", "CL", 20);
        //Autor r = listaAutores.Update(1, "AMADO", "NERVO PAREDES", "EC", 45);
        //Autor r = listaAutores.Read_By_Id(1);
        //Autor[] r = listaAutores.ReadAll();

        //Log.println(Log.VERBOSE, "VERBOSE", "************* "+r.Nombres);



        txtId = findViewById(R.id.txtId);
        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtIsoPais = findViewById(R.id.txtIsoPais);
        txtEdad = findViewById(R.id.txtEdad);
        lblUsuario = findViewById(R.id.lblUsuario);
        lsAutores = new Autores(this, "biblioteca.db", 1);

        // leer los datos del disccionario Extra
        Bundle extra = getIntent().getExtras();
        if( extra != null ) {
            String usuario = extra.getString("usuario");
            String clave = extra.getString("clave");
            lblUsuario.setText("Bienvenido " + usuario);
        }
    }

    public void cmdRegresar_onClick(View v) {
        finish();
    }

    public void  cmdCrear_onClick(View v) {
        Autor r = lsAutores.Create(
                Integer.parseInt( txtId.getText().toString() ),
                txtNombres.getText().toString(),
                txtApellidos.getText().toString(),
                txtIsoPais.getText().toString(),
                Integer.parseInt( txtEdad.getText().toString() )
        );

        if( r != null ) {
            Toast.makeText(this, "Autor creado correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error al crear Autor!!", Toast.LENGTH_LONG).show();
        }
    }

    public void cmdActualizar_onClick(View v) {
        Autor r = lsAutores.Update(
                Integer.parseInt( txtId.getText().toString() ),
                txtNombres.getText().toString(),
                txtApellidos.getText().toString(),
                txtIsoPais.getText().toString(),
                Integer.parseInt( txtEdad.getText().toString() )
        );

        if( r != null ) {
            Toast.makeText(this, "Autor actualizado correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error al actualizar Autor!!", Toast.LENGTH_LONG).show();
        }
    }

    public void cmdLeer_onClick(View v) {
        Autor r = lsAutores.Read_By_Id( Integer.parseInt( txtId.getText().toString() ) );
        if( r != null ) {
            txtNombres.setText( r.Nombres );
            txtApellidos.setText( r.Apellidos );
            txtIsoPais.setText( r.IsoPais );
            txtEdad.setText( String.valueOf( r.Edad ) );
        } else {
            Toast.makeText(this, "Autor no encontrado!", Toast.LENGTH_LONG).show();
        }
    }

    public void cmdEliminar_onClick(View v) {
        boolean r = lsAutores.Delete( Integer.parseInt( txtId.getText().toString() ) );
        if ( r ) {
            txtId.setText("");
            txtNombres.setText("");
            txtApellidos.setText("");
            txtIsoPais.setText("");
            txtEdad.setText("");
            Toast.makeText(this, "Autor eliminado correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error al eliminar Autor!!", Toast.LENGTH_LONG).show();
        }
    }
}