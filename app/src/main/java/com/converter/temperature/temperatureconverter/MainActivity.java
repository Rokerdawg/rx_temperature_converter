package com.converter.temperature.temperatureconverter;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mTempInput;
    RadioButton mCelsius, mFahrenheit;
    float mInputValue;
    Button mClear, mConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTempInput = (EditText) findViewById(R.id.input_value_edit);
        mCelsius = (RadioButton) findViewById(R.id.celsius_radio);
        mFahrenheit = (RadioButton) findViewById(R.id.fahrenheit_radio);
        mConvert = (Button) findViewById(R.id.convert_value);
        mClear = (Button) findViewById(R.id.clear_value);

        mConvert.setOnClickListener(this);
        mClear.setOnClickListener(this);
    }

    private void convertTemps() {
        if (mCelsius.isChecked()) {
            mTempInput.setText("");
            mTempInput.setText(String.valueOf(ConvertUtils.convertCelciusToFahrenheit(mInputValue)));
            mFahrenheit.setChecked(false);
        } else if (mFahrenheit.isChecked()) {
            mTempInput.setText("");
            mTempInput.setText(String.valueOf(ConvertUtils.convertFahrenheitToCelcius(mInputValue)));
            mCelsius.setChecked(false);
        }
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

    @Override
    public void onClick(View view) {
        if (mTempInput.getText().length() == 0) {
            Snackbar.make(view, "Please enter valid temp", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return;
        } else
            mInputValue = Float.parseFloat(mTempInput.getText().toString());
        switch (view.getId()) {
            case R.id.convert_value:
                convertTemps();
                break;
            case R.id.clear_value:
                mTempInput.setText("");
        }
    }



}
