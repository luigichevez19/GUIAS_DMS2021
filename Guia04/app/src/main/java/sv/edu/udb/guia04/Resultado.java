package sv.edu.udb.guia04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class Resultado extends AppCompatActivity {
    private TextView SalaN,iss,rent,afp,nomb;
    String nombre;
    String horaT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        nomb=(TextView) findViewById(R.id.lblNomb2);
        SalaN= (TextView) findViewById(R.id.lblSalaN);
        iss= (TextView) findViewById(R.id.lblISS);
        rent= (TextView) findViewById(R.id.lblRent);
        afp= (TextView) findViewById(R.id.lblAFP);
        //Lee datos del activitie anteior
        Bundle bundle = getIntent().getExtras();
        nombre=bundle.getString("txtNombre");
        horaT =bundle.getString ("txtHoraT");
        calculo();
    }
    void calculo()
    {
        Double i,r,a,s,h;
        h= Double.parseDouble(horaT);
        s=8.50 * h;
        i=s*0.02;
        a=s*0.03;
        r=s*0.04;
        s=s-i-a-r;
        DecimalFormat df = new DecimalFormat("#.00");
        nomb.setText("Su nombre es: "+nombre);
        SalaN.setText("Su salario neto es: "+df.format(s));
        iss.setText("Usted paga de seguro: "+df.format(i));
        afp.setText("Usted paga de AFP: "+df.format(a));
        rent.setText("Usted paga de renta: "+df.format(r));
    }
}