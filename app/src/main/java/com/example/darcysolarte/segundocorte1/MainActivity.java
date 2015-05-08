package com.example.darcysolarte.segundocorte1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class MainActivity extends ActionBarActivity {

    private static final String SOAP_ACTION="http://ws/addUser";
    private static final String METHOD_NAME="addUser";
    private static final String NAMESPACE="http://ws/";
    private static final String URL="http://192.168.1.114:8080/Recuerdos/RecuerdosWS?WSDL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button add = (Button) findViewById(R.id.guardar);
        add.setOnClickListener(new Button.OnClickListener(){
                                   public void onClick(View v){
                                       new Thread() {
                                           public void run() {
                                      SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                                       EditText e1 = (EditText) findViewById(R.id.usuario);
                                       EditText e2 = (EditText) findViewById(R.id.contraseña);


                                       //Toast.makeText(MainActivity.this,"e1",Toast.LENGTH_SHORT).show();
                                       request.addProperty("login", e1.getText().toString());
                                       request.addProperty("pass", Integer.parseInt(e2.getText().toString()));


                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
                envelope.setOutputSoapObject(request);

                try {
                    HttpTransportSE http = new HttpTransportSE(URL);
                    http.call(SOAP_ACTION, envelope);
                    final SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                } catch (Exception e) {
                    e.printStackTrace();
                    ;


                }
                                   }


        }.start();
                                   }
                               });






    }


 /*   public void OnClickaddusers(final View v){

        new Thread() {
            public void run() {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

               //
               // EditText e1 = (EditText) v.findViewById(R.id.usuario);
                 //EditText e2 = (EditText) v.findViewById(R.id.contraseña);

                //Toast.makeText(MainActivity.this,"e1",Toast.LENGTH_SHORT).show();
                //request.addProperty("login", e1.getText().toString());
                //request.addProperty("pass", Integer.parseInt(e2.getText().toString()));


                /*SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
                envelope.setOutputSoapObject(request);

                try {
                    HttpTransportSE http = new HttpTransportSE(URL);
                    http.call(SOAP_ACTION, envelope);
                    final SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                } catch (Exception e) {
                    e.printStackTrace();
                    ;


                }
            }


        }.start();
    }
*/

    public void onClickSiguiente(View v){
        Intent i = new Intent(this, AgregarRecuerdo.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
