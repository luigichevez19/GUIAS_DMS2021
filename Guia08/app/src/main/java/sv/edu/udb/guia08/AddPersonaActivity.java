package sv.edu.udb.guia08;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import sv.edu.udb.guia08.Modelo.Persona;

public class AddPersonaActivity extends AppCompatActivity {
    EditText edtDUI, edtNombre,edtPeso,edtAltura,edtFecha,edtGenero;
    String key="",nombre="",dui="",accion="",fecha="";
    String peso="",altura="",genero="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();

    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        edtFecha = findViewById(R.id.edtFecha);
        edtGenero = findViewById(R.id.edtGenero);
        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        peso = datos.getString("peso");
        altura=datos.getString("altura");
        fecha=datos.getString("fecha");
        genero=datos.getString("genero");
        accion=datos.getString("accion");
        edtDUI.setText(dui);
        edtNombre.setText(nombre);
        edtPeso.setText(peso);
        edtAltura.setText(altura);
        edtFecha.setText(fecha);
        edtGenero.setText(genero);
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        Double peso =  Double.parseDouble( edtPeso.getText().toString());
        Double altura =  Double.parseDouble( edtAltura.getText().toString());
        String fecha = edtFecha.getText().toString();
        String genero =edtGenero.getText().toString();
        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre,peso,altura,fecha,genero);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}
