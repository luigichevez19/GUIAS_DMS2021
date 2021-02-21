package sv.edu.udb.guia04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nombre,horas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre =(EditText) findViewById(R.id.txtNombre);
        horas=(EditText) findViewById(R.id.txtHoraT);
    }

    public void Resultado(View v)
    {
        Intent i = new Intent(this,Resultado.class);
        i.putExtra("txtNombre",nombre.getText().toString());
        i.putExtra("txtHoraT", horas.getText().toString());
        startActivity(i);
    }
    public void finalizar(View v) {
        finish();
    }

}