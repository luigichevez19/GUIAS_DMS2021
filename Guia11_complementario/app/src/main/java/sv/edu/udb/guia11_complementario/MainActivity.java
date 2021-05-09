package sv.edu.udb.guia11_complementario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCodigo,etNombre,etApellido,etEdad, etTelefono;
    private TextView TxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCodigo=(EditText)findViewById(R.id.etCode);
        etNombre=(EditText)findViewById(R.id.etName);
        etApellido=(EditText)findViewById(R.id.etSurname);
        etEdad=(EditText)findViewById(R.id.etAge);
        etTelefono=(EditText)findViewById(R.id.etTelephone);
        TxtView=findViewById(R.id.listaView);

        mostrar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mostrar();
    }

    public void mostrar(){
        AdminSQLiteConection admin = new AdminSQLiteConection(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery("select codigo,nombre,apellido,edad,telefono from persona", null);
        String resultado="";
        if (fila.moveToFirst()) {
            do {

                resultado = resultado + "\n    Codigo: " + fila.getString(0) ;
                resultado = resultado + "\n    Nombre: " +  fila.getString(1) ;
                resultado = resultado + "\n    Apellido:  "+ fila.getString(2);
                resultado = resultado + "\n    Edad: " + fila.getString(3) + " Años";
                resultado = resultado + "\n    Telefono: " + fila.getString(4);
                resultado = resultado + "\n";
            }while (fila.moveToNext());


            TxtView.setText(resultado);
        } else
            Toast.makeText(this, "No hay registros",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void alta(View v) {
        AdminSQLiteConection admin = new AdminSQLiteConection(this,"administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String edad = etEdad.getText().toString();
        String telefono = etTelefono.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("codigo", codigo);
        registro.put("nombre", nombre);
        registro.put("apellido", apellido);
        registro.put("edad", edad);
        registro.put("telefono", telefono);

        try {
            bd.insertOrThrow("persona", null, registro);
            bd.close();
            etCodigo.setText("");
            etNombre.setText("");
            etApellido.setText("");
            etEdad.setText("");
            etTelefono.setText("");
            Toast.makeText(this, "Registro exitoso",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "¡¡ERROR!! Ha fallado el registro" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        startActivity(new Intent(this, MainActivity.class));

    }

    public void consultaporcodigo(View v) {
        AdminSQLiteConection admin = new AdminSQLiteConection(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = etCodigo.getText().toString();
        Cursor fila = bd.rawQuery("select nombre,apellido,edad,telefono from persona where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            etNombre.setText(fila.getString(0));
            etApellido.setText(fila.getString(1));
            etEdad.setText(fila.getString(2));
            etTelefono.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe una persona registrada con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

/*
    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = et2.getText().toString();
        Cursor fila = bd.rawQuery("select codigo,precio from articulos where descripcion='" + descri +"'", null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un artículo con dicha descripción",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
*/
    public void bajaporcodigo(View v) {
        AdminSQLiteConection admin = new AdminSQLiteConection(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= etCodigo.getText().toString();
        int cant = bd.delete("persona", "codigo=" + cod, null);
        bd.close();
        etCodigo.setText("");
        etNombre.setText("");
        etApellido.setText("");
        etEdad.setText("");
        etTelefono.setText("");
        if (cant == 1) {
            Toast.makeText(this, "Se borró el registro exitosamente",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));

        }
        else
            Toast.makeText(this, "No existe una persona con dicho código",
                    Toast.LENGTH_SHORT).show();



    }

    public void modificacion(View v) {
        AdminSQLiteConection admin = new AdminSQLiteConection(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = etCodigo.getText().toString();
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String edad = etEdad.getText().toString();
        String telefono = etTelefono.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", codigo);
        registro.put("nombre", nombre);
        registro.put("apellido", apellido);
        registro.put("edad", edad);
        registro.put("telefono", telefono);
        int cant = bd.update("persona", registro, "codigo=" + codigo, null);
        bd.close();
        if (cant == 1) {
            Toast.makeText(this, "se modificaron los datos exitosamente", Toast.LENGTH_SHORT)
                    .show();
            startActivity(new Intent(this, MainActivity.class));

        }
        else
            Toast.makeText(this, "no existe una persona con el código ingresado",
                    Toast.LENGTH_SHORT).show();


    }
}