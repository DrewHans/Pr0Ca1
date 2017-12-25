package io.github.drewhans555.pr0ca1;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MainActivity Class - the controller
 *
 * @author Tim Francis(https://github.com/tfrancis9514) - View, Controller
 * @author Drew Hans(https://github.com/DrewHans555) - Model, View, Controller, Documentation, Debugging
 * @author Riley Judd(https://github.com/rileyjudd) - Controller
 * @author Samuel Lomanto(https://github.com/SamLomanto) - View, Controller
 * @author Dakota Tebbe(https://github.com/Vulturnus) - View, Controller, Debugging
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String inputMode;
    private String operationSelected;
    private Pr0Number previousNumber;
    private Pr0Number currentNumber;
    private ArithmeticOperator arithmeticOperator;
    private BooleanLogicOperator booleanLogicOperator;
    private TextView tvBINlabel; // the textview that displays BIN
    private TextView tvOCTlabel; // the textview that displays OCT
    private TextView tvDEClabel; // the textview that displays DEC
    private TextView tvHEXlabel; // the textview that displays HEX
    private TextView tvBIN; // the textview that displays currentNumber's binary value
    private TextView tvOCT; // the textview that displays currentNumber's octal value
    private TextView tvDEC; // the textview that displays currentNumber's decimal value
    private TextView tvHEX; // the textview that displays currentNumber's hexadecimal value

    /**
     * onCreate Method - initializes our activity
     *
     * @param savedInstanceState
     */
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

        resizeGUI();

        // initialize our TextView GUI objects
        tvBINlabel = (TextView) findViewById(R.id.BINText);
        tvOCTlabel = (TextView) findViewById(R.id.OCTText);
        tvDEClabel = (TextView) findViewById(R.id.DECText);
        tvHEXlabel = (TextView) findViewById(R.id.HEXText);
        tvBIN = (TextView) findViewById(R.id.textViewBIN);
        tvOCT = (TextView) findViewById(R.id.textViewOCT);
        tvDEC = (TextView) findViewById(R.id.textViewDEC);
        tvHEX = (TextView) findViewById(R.id.textViewHEX);

        // initialize our Pr0Number objects
        previousNumber = new Pr0Number(32, true);
        currentNumber = new Pr0Number(32, true);

        arithmeticOperator = new ArithmeticOperator();
        booleanLogicOperator = new BooleanLogicOperator();

        // set default values for our global Controller variables
        inputMode = getString(R.string.DEC);
        tvDEClabel.setBackgroundResource(R.color.colorPrimaryLight);
        operationSelected = null;

        setTitle(getString(R.string.signed32bit));
    }//end onCreate method

    /**
     * onBackPressed Method - called when the activity has detected the user's press of the back key
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }//end onBackPressed method

    /**
     * onCreateOptionsMenu Method - initializes the contents of the Activity's standard options menu
     *
     * @param menu
     * @return true on success
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }//end onCreateOptionsMenu

    /**
     * onOptionsItemSelected Method - called whenever an item in your options menu is selected
     *
     * @param item
     * @return
     */
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
    }//end onOptionsItemSelected method

    /**
     * onNavigationItemSelected Method - called whenever an item in our Navigation menu is selected
     *
     * @param item - the MenuItem selected
     * @return true on success
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mode_4bitunsigned) {
            // update our Pr0Number objects
            Pr0Number.updateState(4, false);
            setTitle(getString(R.string.unsigned4bit));
        } else if (id == R.id.mode_8bitsigned) {
            // update our Pr0Number objects
            Pr0Number.updateState(8, true);
            setTitle(getString(R.string.signed8bit));
        } else if (id == R.id.mode_8bitunsigned) {
            // update our Pr0Number objects
            Pr0Number.updateState(8, false);
            setTitle(getString(R.string.unsigned8bit));
        } else if (id == R.id.mode_16bitsigned) {
            // update our Pr0Number objects
            Pr0Number.updateState(16, true);
            setTitle(getString(R.string.signed16bit));
        } else if (id == R.id.mode_16bitunsigned) {
            // update our Pr0Number objects
            Pr0Number.updateState(16, false);
            setTitle(getString(R.string.unsigned16bit));
        } else if (id == R.id.mode_32bitsigned) {
            // update our Pr0Number objects
            Pr0Number.updateState(32, true);
            setTitle(getString(R.string.signed32bit));
        }

        this.resetCalculator();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }//end onNavigationItemSelected method

    /**
     * resizeGUI Method - manually scales GUI elements to match device's height and width
     */
    private void resizeGUI() {
        // get the device's height and width in pixels
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int heightPxs = metrics.heightPixels;
        int widthPxs = metrics.widthPixels;

        // manually resize the outter LinearLayout
        LinearLayout linearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayoutContainer);
        LayoutParams linearLayoutParams = linearLayoutContainer.getLayoutParams();
        linearLayoutParams.width = widthPxs;
        linearLayoutParams.height = heightPxs;

        /*
        // manually resize each LinearLayout button row so that each button's height = width (square buttons look better)
        int buttonWidth = widthPxs / 4; //4 buttons per row => each button has widthPxs/4 of width (except for the equal button)

        LinearLayout linearLayoutButtonRow1 = (LinearLayout) findViewById(R.id.linearLayoutButtonRow1);
        LayoutParams linearLayoutBR1Params = linearLayoutButtonRow1.getLayoutParams();
        linearLayoutBR1Params.height = buttonWidth;

        LinearLayout linearLayoutButtonRow2 = (LinearLayout) findViewById(R.id.linearLayoutButtonRow2);
        LayoutParams linearLayoutBR2Params = linearLayoutButtonRow2.getLayoutParams();
        linearLayoutBR2Params.height = buttonWidth;

        LinearLayout linearLayoutButtonRow3 = (LinearLayout) findViewById(R.id.linearLayoutButtonRow3);
        LayoutParams linearLayoutBR3Params = linearLayoutButtonRow3.getLayoutParams();
        linearLayoutBR3Params.height = buttonWidth;

        LinearLayout linearLayoutButtonRow4 = (LinearLayout) findViewById(R.id.linearLayoutButtonRow4);
        LayoutParams linearLayoutBR4Params = linearLayoutButtonRow4.getLayoutParams();
        linearLayoutBR4Params.height = buttonWidth;

        LinearLayout linearLayoutButtonRow5 = (LinearLayout) findViewById(R.id.linearLayoutButtonRow5);
        LayoutParams linearLayoutBR5Params = linearLayoutButtonRow5.getLayoutParams();
        linearLayoutBR5Params.height = buttonWidth;

        LinearLayout linearLayoutButtonRow6 = (LinearLayout) findViewById(R.id.linearLayoutButtonRow6);
        LayoutParams linearLayoutBR6Params = linearLayoutButtonRow6.getLayoutParams();
        linearLayoutBR6Params.height = buttonWidth;

        LinearLayout linearLayoutButtonRow7 = (LinearLayout) findViewById(R.id.linearLayoutButtonRow7);
        LayoutParams linearLayoutBR7Params = linearLayoutButtonRow7.getLayoutParams();
        linearLayoutBR7Params.height = buttonWidth;

        LinearLayout linearLayoutButtonRow8 = (LinearLayout) findViewById(R.id.linearLayoutButtonRow8);
        LayoutParams linearLayoutBR8Params = linearLayoutButtonRow8.getLayoutParams();
        linearLayoutBR8Params.height = buttonWidth;
         */
    }//end resizeGUI method


    /**
     * onPressBin Method - called when user pressed the BIN TextView
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressBin(View view) {
        inputMode = getString(R.string.BIN);
        tvDEClabel.setBackgroundResource(R.color.transparent);
        tvHEXlabel.setBackgroundResource(R.color.transparent);
        tvOCTlabel.setBackgroundResource(R.color.transparent);
        tvBINlabel.setBackgroundResource(R.color.colorPrimaryLight);
    }//end onPressBin method

    /**
     * onPressOct Method - called when user pressed the OCT TextView
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressOct(View view) {
        inputMode = getString(R.string.OCT);
        tvDEClabel.setBackgroundResource(R.color.transparent);
        tvHEXlabel.setBackgroundResource(R.color.transparent);
        tvOCTlabel.setBackgroundResource(R.color.colorPrimaryLight);
        tvBINlabel.setBackgroundResource(R.color.transparent);
    }//end onPressOct method

    /**
     * onPressDec Method - called when user pressed the DEC TextView
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressDec(View view) {
        inputMode = getString(R.string.DEC);
        tvDEClabel.setBackgroundResource(R.color.colorPrimaryLight);
        tvHEXlabel.setBackgroundResource(R.color.transparent);
        tvOCTlabel.setBackgroundResource(R.color.transparent);
        tvBINlabel.setBackgroundResource(R.color.transparent);
    }//end onPressDec method

    /**
     * onPressHex Method - called when user pressed the HEX TextView
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressHex(View view) {
        inputMode = getString(R.string.HEX);
        tvDEClabel.setBackgroundResource(R.color.transparent);
        tvHEXlabel.setBackgroundResource(R.color.colorPrimaryLight);
        tvOCTlabel.setBackgroundResource(R.color.transparent);
        tvBINlabel.setBackgroundResource(R.color.transparent);
    }//end onPressHex method


    /**
     * onPress0 - called when the user presses the 0 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress0(View view) {
        appendButtonInput(getString(R.string.zero));
    }//end onPress0 method

    /**
     * onPress1 - called when the user presses the 1 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress1(View view) {
        appendButtonInput(getString(R.string.one));
    }//end onPress1 method

    /**
     * onPress2 - called when the user presses the 2 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress2(View view) {
        appendButtonInput(getString(R.string.two));
    }//end onPress2 method

    /**
     * onPress3 - called when the user presses the 3 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress3(View view) {
        appendButtonInput(getString(R.string.three));
    }//end onPress3 method

    /**
     * onPress4 - called when the user presses the 4 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress4(View view) {
        appendButtonInput(getString(R.string.four));
    }//end onPress4 method

    /**
     * onPress5 - called when the user presses the 5 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress5(View view) {
        appendButtonInput(getString(R.string.five));
    }//end onPress5 method

    /**
     * onPress6 - called when the user presses the 6 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress6(View view) {
        appendButtonInput(getString(R.string.six));
    }//end onPress6 method

    /**
     * onPress7 - called when the user presses the 7 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress7(View view) {
        appendButtonInput(getString(R.string.seven));
    }//end onPress7 method

    /**
     * onPress8 - called when the user presses the 8 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress8(View view) {
        appendButtonInput(getString(R.string.eight));
    }//end onPress8 method

    /**
     * onPress9 - called when the user presses the 9 button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPress9(View view) {
        appendButtonInput(getString(R.string.nine));
    }//end onPress9 method

    /**
     * onPressA - called when the user presses the A button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressA(View view) {
        appendButtonInput(getString(R.string.a));
    }//end onPressA method

    /**
     * onPressB - called when the user presses the B button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressB(View view) {
        appendButtonInput(getString(R.string.b));
    }//end onPressB method

    /**
     * onPressC - called when the user presses the C button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressC(View view) {
        appendButtonInput(getString(R.string.c));
    }//end onPressC method

    /**
     * onPressD - called when the user presses the D button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressD(View view) {
        appendButtonInput(getString(R.string.d));
    }//end onPressD method

    /**
     * onPressE - called when the user presses the E button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressE(View view) {
        appendButtonInput(getString(R.string.e));
    }//end onPressE method

    /**
     * onPressF - called when the user presses the F button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressF(View view) {
        appendButtonInput(getString(R.string.f));
    }//end onPressF method

    /**
     * onPressNot Method - called when the user presses the NOT button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressNot(View view) {
        this.setNextOperation(view, getString(R.string.NOT));
        this.onPressEqual(view);
    }//end onPressNot method

    /**
     * onPressAnd Method - called when the user presses the AND button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressAnd(View view) {
        this.setNextOperation(view, getString(R.string.AND));
    }//end onPressAnd method

    /**
     * onPressOr Method - called when the user presses the OR button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressOr(View view) {
        this.setNextOperation(view, getString(R.string.OR));
    }//end onPressOr method

    /**
     * onPressXor Method - called when the user presses the XOR button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressXor(View view) {
        this.setNextOperation(view, getString(R.string.XOR));
    }//end onPressXor method

    /**
     * onPressNand Method - called when the user presses the NAND button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressNand(View view) {
        this.setNextOperation(view, getString(R.string.NAND));
    }//end onPressNand method

    /**
     * onPressNor Method - called when the user presses the NOR button
     *
     * @param view - View object that gets passed in on call
     */

    public void onPressNor(View view) {
        this.setNextOperation(view, getString(R.string.NOR));
    }//end onPressNor method

    /**
     * onPressXnor Method - called when the user presses the XNOR button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressXnor(View view) {
        this.setNextOperation(view, getString(R.string.XNOR));
    }//end onPressXnor method

    /**
     * onPressAdd Method - called when the user presses the + button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressAdd(View view) {
        this.setNextOperation(view, getString(R.string.add));
    }//end onPressAdd method method

    /**
     * onPressSubtract Method - called when the user presses the - button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressSubtract(View view) {
        this.setNextOperation(view, getString(R.string.sub));
    }//end onPressSubtract method

    /**
     * onPressMultiply Method - called when the user presses the * button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressMultiply(View view) {
        this.setNextOperation(view, getString(R.string.mul));
    }//end onPressMultiply method

    /**
     * onPressDivide Method - called when the user presses the / button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressDivide(View view) {
        this.setNextOperation(view, getString(R.string.div));
    }//end onPressDivide method

    /**
     * onPressMod Method - called when the user presses the MOD button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressMod(View view) {
        this.setNextOperation(view, getString(R.string.mod));
    }//end onPressMod method

    /**
     * onPressEqual Method - called when the user presses the = button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressEqual(View view) {
        try {
            if (this.operationSelected != null) {
                if (this.operationSelected.equalsIgnoreCase(getString(R.string.NOT))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setBinValue(
                            this.booleanLogicOperator.not(Pr0Number.getBitPrecision(), this.previousNumber.getBinValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.AND))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setBinValue(
                            this.booleanLogicOperator.and(this.previousNumber.getBinValue(), this.currentNumber.getBinValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.OR))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setBinValue(
                            this.booleanLogicOperator.or(this.previousNumber.getBinValue(), this.currentNumber.getBinValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.XOR))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setBinValue(
                            this.booleanLogicOperator.xor(this.previousNumber.getBinValue(), this.currentNumber.getBinValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.NAND))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setBinValue(
                            this.booleanLogicOperator.nand(Pr0Number.getBitPrecision(), this.previousNumber.getBinValue(), this.currentNumber.getBinValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.NOR))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setBinValue(
                            this.booleanLogicOperator.nor(Pr0Number.getBitPrecision(), this.previousNumber.getBinValue(), this.currentNumber.getBinValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.XNOR))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setBinValue(
                            this.booleanLogicOperator.xnor(Pr0Number.getBitPrecision(), this.previousNumber.getBinValue(), this.currentNumber.getBinValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.add))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setDecValue(
                            this.arithmeticOperator.add(this.previousNumber.getDecValue(), this.currentNumber.getDecValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.sub))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setDecValue(
                            this.arithmeticOperator.sub(this.previousNumber.getDecValue(), this.currentNumber.getDecValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.mul))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setDecValue(
                            this.arithmeticOperator.mul(this.previousNumber.getDecValue(), this.currentNumber.getDecValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.div))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setDecValue(
                            this.arithmeticOperator.div(this.previousNumber.getDecValue(), this.currentNumber.getDecValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else if (this.operationSelected.equalsIgnoreCase(getString(R.string.mod))) {
                    this.operationSelected = null; //reset the operation
                    this.currentNumber.setDecValue(
                            this.arithmeticOperator.mod(this.previousNumber.getDecValue(), this.currentNumber.getDecValue()));
                    this.previousNumber.clearValues();
                    this.updateTextViews();
                } else {
                    // some unexpected operation was set
                    this.operationSelected = null; //reset the operation
                    this.previousNumber.clearValues();
                    this.currentNumber.clearValues();
                    this.updateTextViews();
                }
            }
        } catch (Exception e) {
            this.showInputErrToast();
            this.resetCalculator();
        }
    }//end onPressEqual method

    /**
     * onPressAc Method - called when the user presses the AC button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressAc(View view) {
        this.resetCalculator();
    }//end onPressAC method

    /**
     * onPressDel Method - called when the user presses the DEL button
     *
     * @param view - View object that gets passed in on call
     */
    public void onPressDel(View view) {
        try {
            if (tvBIN.getText().toString().length() > 0 && inputMode.equalsIgnoreCase(getString(R.string.BIN))) {
                this.currentNumber.deappendBinValue();
                updateTextViews(); //only update on change
            } else if (tvDEC.getText().toString().length() > 0 && inputMode.equalsIgnoreCase(getString(R.string.DEC))) {
                this.currentNumber.deappendDecValue();
                updateTextViews(); //only update on change
            } else if (tvOCT.getText().toString().length() > 0 && inputMode.equalsIgnoreCase(getString(R.string.OCT))) {
                this.currentNumber.deappendOctValue();
                updateTextViews(); //only update on change
            } else if (tvHEX.getText().toString().length() > 0 && inputMode.equalsIgnoreCase(getString(R.string.HEX))) {
                this.currentNumber.deappendHexValue();
                updateTextViews(); //only update on change
            }
        } catch (Exception e) {
            this.showInputErrToast();
            this.resetCalculator();
        }
    }//end onPressDel method

    /**
     * appendButtonInput Method - called by every onPress button method, appends input if legal
     *
     * @param buttonValue - string value of the pressed button
     */
    private void appendButtonInput(String buttonValue) {
        String legalBinInputs = "01";
        String legalOctInputs = "01234567";
        String legalDecInputs = "0123456789";
        String legalHexInputs = "0123456789ABCDEF";
        String buffer;

        try {
            if (inputMode.equalsIgnoreCase(getString(R.string.BIN)) && legalBinInputs.contains(buttonValue) && tvBIN.length() + 1 < 33) {
                this.currentNumber.appendBinValue(buttonValue);
                updateTextViews(); // update TextViews only on legal button presses
            } else if (inputMode.equalsIgnoreCase(getString(R.string.OCT)) && legalOctInputs.contains(buttonValue) && tvOCT.length() + 1 < 12) {
                this.currentNumber.appendOctValue(buttonValue);
                updateTextViews(); // update TextViews only on legal button presses
            } else if (inputMode.equalsIgnoreCase(getString(R.string.DEC)) && legalDecInputs.contains(buttonValue) && tvDEC.length() + 1 < 11) {
                this.currentNumber.appendDecValue(buttonValue);
                updateTextViews(); // update TextViews only on legal button presses
            } else if (inputMode.equalsIgnoreCase(getString(R.string.HEX)) && legalHexInputs.contains(buttonValue) && tvHEX.length() + 1 < 9) {
                this.currentNumber.appendHexValue(buttonValue);
                updateTextViews(); // update TextViews only on legal button presses
            }
        } catch (Exception e) {
            //do nothing, let them continue pressing buttons in vain
        }
    }//end appendButtonInput method

    /**
     * clearTextViews Method - clears all of our TextViews
     */
    public void clearTextViews() {
        tvBIN.setText("");
        tvOCT.setText("");
        tvDEC.setText("");
        tvHEX.setText("");
    }//end onPressAC method

    /**
     * resetCalculator Method - resets calculator state
     */
    public void resetCalculator() {
        this.operationSelected = null;
        this.currentNumber.clearValues();
        this.previousNumber.clearValues();
        clearTextViews();
        showCalculatorResetToast();
    }//end resetCalculator method

    /**
     * setNextOperation Method - called when user presses an operation button
     *
     * @param view - View object that gets passed in on call
     */
    public void setNextOperation(View view, String op) {
        if (this.operationSelected != null) {
            this.onPressEqual(view);
        }
        this.operationSelected = op;
        this.setPreviousNumber();
    }//end setPreviousInput method

    /**
     * setPreviousInput Method - called whenever we need to store user input
     *
     * @param view - View object that gets passed in on call
     */
    public void setPreviousNumber() {
        this.previousNumber.copyPr0Number(this.currentNumber);
        this.currentNumber.clearValues();
    }//end setPreviousInput method

    /**
     * showCalculatorResetToast Method - called after resetCalculator method is called
     */
    public void showCalculatorResetToast() {
        Context context = getApplicationContext();
        CharSequence text = "The calculator has been reset.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }//end showCalculatorResetToast method

    /**
     * showInputErrToast Method - called whenever an exception is caught in setPreviousInput
     */
    public void showInputErrToast() {
        Context context = getApplicationContext();
        CharSequence text = "Invalid input. Calculator will now be reset.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }//end showPreviousInputErrToast method

    /**
     * updateTextViews Method - updates the TextViews with the currentNumber's bin/oct/dec/hex values
     */
    public void updateTextViews() {
        tvBIN.setText(this.currentNumber.getBinValue());
        tvOCT.setText(this.currentNumber.getOctValue());
        tvDEC.setText(this.currentNumber.getDecValue());
        tvHEX.setText(this.currentNumber.getHexValue());
    }//end updateTextViews method

}//end MainActivity class
