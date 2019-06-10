package io.github.drewhans555.pr0ca1;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private IPr0Calculator pr0Calculator;

    private TextView tvBINlabel;
    private TextView tvOCTlabel;
    private TextView tvDEClabel;
    private TextView tvHEXlabel;
    private TextView tvBIN;
    private TextView tvOCT;
    private TextView tvDEC;
    private TextView tvHEX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // leave everything above this line alone in onCreate method

        // initialize our concrete objects & inject dependencies
        int bitState = 32;
        boolean signState = true;
        Pr0Mode inputState = Pr0Mode.DEC;
        IArithmeticOperator arithmeticOperator = new ArithmeticOperator();
        IBooleanLogicOperator booleanLogicOperator = new BooleanLogicOperator();
        IBoundsChecker boundsChecker = new BoundsChecker();
        IBaseConverter baseConverter = new BaseConverter(boundsChecker);
        IPr0Number previousNumber = new Pr0Number(baseConverter, boundsChecker, bitState, signState);
        IPr0Number currentNumber = new Pr0Number(baseConverter, boundsChecker, bitState, signState);

        pr0Calculator = new Pr0Calculator(arithmeticOperator, booleanLogicOperator, previousNumber, currentNumber, inputState);

        // initialize our TextView GUI objects
        tvBINlabel = (TextView) findViewById(R.id.BINText);
        tvOCTlabel = (TextView) findViewById(R.id.OCTText);
        tvDEClabel = (TextView) findViewById(R.id.DECText);
        tvHEXlabel = (TextView) findViewById(R.id.HEXText);
        tvBIN = (TextView) findViewById(R.id.textViewBIN);
        tvOCT = (TextView) findViewById(R.id.textViewOCT);
        tvDEC = (TextView) findViewById(R.id.textViewDEC);
        tvHEX = (TextView) findViewById(R.id.textViewHEX);

        tvDEClabel.setBackgroundResource(R.color.colorPrimaryLight);
        setTitle(getString(R.string.signed32bit));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button_number, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        Save this for when you want to add themes and other settings to Pr0Ca1
        if (id == R.id.action_settings) {
            return true;
        }
        */

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mode_4bitunsigned) {
            pr0Calculator.updateState(4, false);
            setTitle(getString(R.string.unsigned4bit));
        } else if (id == R.id.mode_8bitsigned) {
            pr0Calculator.updateState(8, true);
            setTitle(getString(R.string.signed8bit));
        } else if (id == R.id.mode_8bitunsigned) {
            pr0Calculator.updateState(8, false);
            setTitle(getString(R.string.unsigned8bit));
        } else if (id == R.id.mode_16bitsigned) {
            pr0Calculator.updateState(16, true);
            setTitle(getString(R.string.signed16bit));
        } else if (id == R.id.mode_16bitunsigned) {
            pr0Calculator.updateState(16, false);
            setTitle(getString(R.string.unsigned16bit));
        } else if (id == R.id.mode_32bitsigned) {
            pr0Calculator.updateState(32, true);
            setTitle(getString(R.string.signed32bit));
        }

        clearTextViews();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onPressBin(View view) {
        pr0Calculator.setInputMode(Pr0Mode.BIN);
        tvDEClabel.setBackgroundResource(R.color.transparent);
        tvHEXlabel.setBackgroundResource(R.color.transparent);
        tvOCTlabel.setBackgroundResource(R.color.transparent);
        tvBINlabel.setBackgroundResource(R.color.colorPrimaryLight);
    }

    public void onPressOct(View view) {
        pr0Calculator.setInputMode(Pr0Mode.OCT);
        tvDEClabel.setBackgroundResource(R.color.transparent);
        tvHEXlabel.setBackgroundResource(R.color.transparent);
        tvOCTlabel.setBackgroundResource(R.color.colorPrimaryLight);
        tvBINlabel.setBackgroundResource(R.color.transparent);
    }

    public void onPressDec(View view) {
        pr0Calculator.setInputMode(Pr0Mode.DEC);
        tvDEClabel.setBackgroundResource(R.color.colorPrimaryLight);
        tvHEXlabel.setBackgroundResource(R.color.transparent);
        tvOCTlabel.setBackgroundResource(R.color.transparent);
        tvBINlabel.setBackgroundResource(R.color.transparent);
    }

    public void onPressHex(View view) {
        pr0Calculator.setInputMode(Pr0Mode.HEX);
        tvDEClabel.setBackgroundResource(R.color.transparent);
        tvHEXlabel.setBackgroundResource(R.color.colorPrimaryLight);
        tvOCTlabel.setBackgroundResource(R.color.transparent);
        tvBINlabel.setBackgroundResource(R.color.transparent);
    }

    public void onPress0(View view) {
        pr0Calculator.press0Button();
        updateTextViews();
    }

    public void onPress1(View view) {
        pr0Calculator.press1Button();
        updateTextViews();
    }

    public void onPress2(View view) {
        pr0Calculator.press2Button();
        updateTextViews();
    }

    public void onPress3(View view) {
        pr0Calculator.press3Button();
        updateTextViews();
    }

    public void onPress4(View view) {
        pr0Calculator.press4Button();
        updateTextViews();
    }

    public void onPress5(View view) {
        pr0Calculator.press5Button();
        updateTextViews();
    }

    public void onPress6(View view) {
        pr0Calculator.press6Button();
        updateTextViews();
    }

    public void onPress7(View view) {
        pr0Calculator.press7Button();
        updateTextViews();
    }

    public void onPress8(View view) {
        pr0Calculator.press8Button();
        updateTextViews();
    }

    public void onPress9(View view) {
        pr0Calculator.press9Button();
        updateTextViews();
    }

    public void onPressA(View view) {
        pr0Calculator.pressAButton();
        updateTextViews();
    }

    public void onPressB(View view) {
        pr0Calculator.pressBButton();
        updateTextViews();
    }

    public void onPressC(View view) {
        pr0Calculator.pressCButton();
        updateTextViews();
    }

    public void onPressD(View view) {
        pr0Calculator.pressDButton();
        updateTextViews();
    }

    public void onPressE(View view) {
        pr0Calculator.pressEButton();
        updateTextViews();
    }

    public void onPressF(View view) {
        pr0Calculator.pressFButton();
        updateTextViews();
    }

    public void onPressNot(View view) {
        try {
            pr0Calculator.pressNotButton();
            updateTextViews();
        } catch (NumberOutOfModeBoundsException iae) {
            this.showToast("NumberOutOfModeBoundsException thrown. Calculator will now be reset.");
            resetCalculator();
        } catch (IllegalArgumentException iae) {
            this.showToast("IllegalArgumentException thrown. Calculator will now be reset.");
            resetCalculator();
        } catch (Exception e) {
            this.showToast("Exception thrown. Calculator will now be reset.");
            resetCalculator();
        }
    }

    public void onPressAnd(View view) {
        try {
            pr0Calculator.pressAndButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressOr(View view) {
        try {
            pr0Calculator.pressOrButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressXor(View view) {
        try {
            pr0Calculator.pressXorButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressNand(View view) {
        try {
            pr0Calculator.pressNandButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressNor(View view) {
        try {
            pr0Calculator.pressNorButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressXnor(View view) {
        try {
            pr0Calculator.pressXnorButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressAdd(View view) {
        try {
            pr0Calculator.pressAddButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressSubtract(View view) {
        try {
            pr0Calculator.pressSubtractButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressMultiply(View view) {
        try {
            pr0Calculator.pressMultiplyButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressDivide(View view) {
        try {
            pr0Calculator.pressDivideButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressMod(View view) {
        try {
            pr0Calculator.pressModButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressEqual(View view) {
        try {
            pr0Calculator.pressEqualButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            resetCalculator();
        }
    }

    public void onPressAc(View view) {
        pr0Calculator.pressAcButton();
        clearTextViews();
    }

    public void onPressDel(View view) {
        try {
            pr0Calculator.pressDeleteButton();
            updateTextViews();
        } catch (Exception e) {
            this.showToast(e.getMessage());
            this.resetCalculator();
        }
    }

    private void clearTextViews() {
        tvBIN.setText("");
        tvOCT.setText("");
        tvDEC.setText("");
        tvHEX.setText("");
    }

    private void resetCalculator() {
        pr0Calculator.reset();
        clearTextViews();
    }

    private void showToast(String msg) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }

    private void updateTextViews() {
        IPr0Number currentNumber = pr0Calculator.getCurrentNumber();
        tvBIN.setText(currentNumber.getBinValue());
        tvOCT.setText(currentNumber.getOctValue());
        tvDEC.setText(currentNumber.getDecValue());
        tvHEX.setText(currentNumber.getHexValue());
    }

}
