package sv.edu.udb.guia03app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView num;
int Conta=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=(TextView) findViewById(R.id.lblNum);
    }
    public void sumar(View view)
    {
        String valor=num.getText().toString();
        int n = Integer.parseInt(valor);
        if(n<9)n++;
        else if(n==9)n=1;
        String resu= String.valueOf(n);
        num.setText(resu);
    }
}