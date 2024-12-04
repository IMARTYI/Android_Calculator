package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //Declare View where user enters Input and result is computed after pressing equal sign


    double currentNumb=0;

    TextView MainView;

    boolean error= false;
    TextView Recall;

    boolean oneDecimalPoint=true; // ensure that only one decimal point is on display
    boolean pressed_Equal = false;
    int pressedEqualNumb = 0;

    double operand_1, operand_2,result;
    char operator=' ';
    double storedValue = 0;
    boolean computed = false;

    //Declare All operators
    Button Addition,Subtraction,Multiplication,Division,Clear,DecimalPoint;
    //Declare All Buttons
    Button NumberZero,NumberOne,NumberTwo,NumberThree,NumberFour,NumberFive,NumberSix,NumberSeven,NumberEight,NumberNine;

    Button Equal;
    boolean replaceOperand= false;

    String lastButtonPressed = " ";

    Button Correct;

    Button storeButton;

    Button recallButton;
    int operatorPressed= 0;

    Button Negative;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainView  = findViewById(R.id.reuslt_display);
        Recall = findViewById(R.id.RecallValue);
        this.Clear = findViewById(R.id.All_Clear);
        operand_1= Double.NaN;
        operand_2 = Double.NaN;

        DeclareButtons(); //Initialize All Buttons
        InitilizeOperators(); // Initialize All Operators
        DisplayNumber(); // Write Numbers to the Display
        presentStoredValue(storedValue);
        clear(); // Function to Clear total and Display

        TranslationTest t= new TranslationTest();
    }
    public void DeclareButtons(){

        this.NumberZero = findViewById(R.id.zero);
        this.NumberOne = findViewById(R.id.one);
        this.NumberTwo = findViewById(R.id.two);
        this.NumberThree = findViewById(R.id.three);
        this.NumberFour = findViewById(R.id.four);
        this.NumberFive = findViewById(R.id.five);
        this.NumberSix = findViewById(R.id.six);
        this.NumberSeven = findViewById(R.id.Seven);
        this.NumberEight =  findViewById(R.id.eight);
        this.NumberNine = findViewById(R.id.nine);

        // Initialize operators
        this.Addition = findViewById(R.id.addition);
        this.Subtraction = findViewById(R.id.subtract);
        this.Multiplication = findViewById(R.id.multiply);
        this.Division = findViewById(R.id.Divide);
        this.DecimalPoint = findViewById(R.id.decimal);
        this.Equal = findViewById(R.id.equals);
        this.Correct = findViewById(R.id.Correct);
        this.storeButton= findViewById(R.id.Save);
        this.recallButton = findViewById(R.id.Restore);
        this.Negative = findViewById(R.id.Negative);
    }

    // Function to Clear the Display and Calculations
    void clear(){
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainView.setText(" ");
                MainView.setText("0");
                operand_1 = Double.NaN;
                operand_2 = Double.NaN;
                operator =' ';
                oneDecimalPoint = true;
                computed = false;
                lastButtonPressed = " ";
                pressed_Equal = false;
                storedValue = 0;
                presentStoredValue(storedValue);
            }
        });
    }

    public void DisplayNumber(){
        NumberZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lastButtonPressed = "Number";
                DisplayMainView("0");
            }
        });
        NumberOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  currentNumb=  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("1");
            }
        });
        NumberTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentNumb=  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("2");
            }
        });
        NumberThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // currentNumb=  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("3");
            }
        });
        NumberFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentNumb=  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("4");
            }
        });
        NumberFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentNumb=  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("5");
            }
        });

        NumberSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentNumb =  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("6");
            }
        });

        NumberSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentNumb=  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("7");
            }
        });
        NumberEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentNumb=  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("8");
            }
        });
        NumberNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentNumb=  Double.parseDouble(MainView.getText().toString());
                lastButtonPressed = "Number";
                DisplayMainView("9");
            }
        });

    }

    void InitilizeOperators(){

        // Declare the operator buttons
        Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lastButtonPressed = "Operator";
                 handleOperator('+');

            }
        });

        Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  lastButtonPressed = "Operator";
                  handleOperator('-');
            }
        });

        Multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 lastButtonPressed = "Operator";
                 handleOperator('*');
            }
        });

        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lastButtonPressed ="Operator";
                   handleOperator('/');
            }
        });

        // This will Call the compute Function to get the result
        Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lastButtonPressed = "Equal";
                pressed_Equal = true;
                pressedEqualNumb++;
                ComputeResult();
            }
        });

        DecimalPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(oneDecimalPoint){
                    DisplayMainView(".");
                    oneDecimalPoint = false;
                    if (MainView.getText().toString().equals(" ")){
                        DisplayMainView(".");
                    }
                }
            }
        });
        Correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct();
            }
        });
        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoreNumber();
                presentStoredValue(storedValue);
            }
        });
        
        recallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecallValue(storedValue);
            }
        });

        Negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negativeSign();
            }
        });
    }

    /**
     * Retrieves each state of the variables when screen is rotated
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        operand_1 = savedInstanceState.getDouble("operand_1");
        operand_2 =  savedInstanceState.getDouble("operand_2");
        result = savedInstanceState.getDouble("result");
        operator = savedInstanceState.getChar("operator");
        storedValue= savedInstanceState.getDouble("storedValue");
        lastButtonPressed = savedInstanceState.getString("lastButtonPressed");
        computed = savedInstanceState.getBoolean("computed");
        pressed_Equal = savedInstanceState.getBoolean("pressed_Equal");
        error = savedInstanceState.getBoolean("error");
        pressedEqualNumb = savedInstanceState.getInt("pressedEqualNumb");
        oneDecimalPoint = savedInstanceState.getBoolean("oneDecimalPoint");
        operatorPressed = savedInstanceState.getInt("operatorPressed");
        replaceOperand = savedInstanceState.getBoolean("replaceOperand");
        currentNumb = savedInstanceState.getDouble("currentNumb");
        MainView.setText(savedInstanceState.getString("current_display"));
        Recall.setText(String.format("R: %s", savedInstanceState.getDouble("storedValue")));
        super.onRestoreInstanceState(savedInstanceState);
        
    }

    /**
     * This function saves the sate each of the variables when the user rotates the screen
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putDouble("operand_1",operand_1);
        outState.putDouble("operand_2",operand_2);
        outState.putDouble("result",result);
        outState.putChar("operator",operator);
        outState.putDouble("storedValue",storedValue);
        outState.putBoolean("computed",computed);
        outState.putBoolean("pressed_Equal",pressed_Equal);
        outState.putBoolean("error",error);
        outState.putString("lastButtonPressed",lastButtonPressed);
        outState.putInt("pressedEqualNumb",pressedEqualNumb);
        outState.putBoolean("oneDecimalPoint",oneDecimalPoint);
        outState.putInt("operatorPressed",operatorPressed);
        outState.putBoolean("replaceOperand",replaceOperand);
        outState.putDouble("currentNumb",currentNumb);
        outState.putString("current_display",MainView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    //Feature to add Negative sign operations
    public void negativeSign(){

        double val=0;

        // case When user applies negative sign to second operand
        if(MainView.getText().toString().equals(" ") && lastButtonPressed.equals("Operator")){
            MainView.setText("-");
        }
        else{

            //multiply value by negative -1
            val = Double.parseDouble(MainView.getText().toString())*-1;

            // zero cannot be negative
            if(val==0){
                MainView.setText("0");
            } else{
                if(Math.floor(val)==val){ // cast to integer if number is a whole number
                    int numb = (int) val;
                    MainView.setText(String.valueOf(numb));
                }else{
                    MainView.setText(String.valueOf(val)); // remain a double
                }
            }
        }
    }
    /**
     * This function simply is used to store the number
     */
    public void StoreNumber(){
        // save the number that is being presented in the main view
        if(!MainView.getText().toString().equals(" ") && lastButtonPressed.equals("Number")){
            this.storedValue = Double.parseDouble(MainView.getText().toString());
            // if the last number pressed was an operator, the first operand will be stored
        } else if(Objects.equals(lastButtonPressed, "Operator") && MainView.getText().toString().equals(" ") && !Double.isNaN(operand_1)){
            this.storedValue = operand_1;
            // grabs the last number computed from previous computation
        } else if(!MainView.getText().toString().equals(" ") && lastButtonPressed.equals("Equal")){
            this.storedValue = Double.parseDouble(MainView.getText().toString());
            //set stored value to 0 otherwise
        } else{
            this.storedValue = 0;
        }
    }
    /**
     *
     * @param recall Takes in the number that is stored
     * Simply restores the number that is stored in memory.
     */
    void RecallValue(double recall){
        // recall number when no previous actions where done by the user
        if(lastButtonPressed == " " || lastButtonPressed == "Equal"){
            String temp = Double.toString(recall);
            MainView.setText(temp);
            // replace the number on the main view with the stored number
        } else if(lastButtonPressed.equals("Number")){
            String temp = Double.toString(recall);
            MainView.setText(temp);
            // recall the number stored in memory as the second operator
        } else if(lastButtonPressed.equals("Operator")){
            String temp = Double.toString(recall);
            MainView.setText(temp);
        }
    }


    /**
     * @param temp takes in the number that is currently stored and displays it the text view
     */
    void presentStoredValue(double temp ){
        String value = null;

        // if the number is a while number, present it as an integer
        if(Math.floor(temp)== temp) {
            int numb = (int)temp;
            value =Integer.toString(numb);
            Recall.setText(" ");
            Recall.setText(String.format("R:%s", value));
            // if the number is a decimal, present it as such
        }else {
            String text = Recall.getText().toString();
            value = Double.toString(temp);
            Recall.setText(" ");
            Recall.setText(String.format("%s%s", text, value));

        }
    }


    /**
     * Function in which removes the last button the user pressed from the operation
     * removes digits as well as operands
     */
    void correct(){
        String Current_text =  MainView.getText().toString();
        // no action if current text is nothing or last button pressed was equals
        if(Current_text == "0"|| lastButtonPressed ==" ") {
            return;
        }
        if(lastButtonPressed.equals("Operator") && ! Double.isNaN(operand_1)){ // Reset the operator and display the intial operator

            // if number is a whole number, present as an integer.
            if(Math.floor(operand_1)==operand_1){
                String temp_1 = Double.toString(operand_1);
                MainView.setText(temp_1);
                this.operator = ' ';
                // other wise present as a decimal
            }else{
                String temp_1 = Double.toString(operand_1);
                MainView.setText(temp_1);
            }
        }

        // if the last button pressed was a digit, remove it

        if(lastButtonPressed.equals("Number")){ //

            String currentNumb = MainView.getText().toString();  // grab current number display

            // if length is greater than one
            if(currentNumb.length()>1) {

                // if decimal is removed change boolean to true
                if(currentNumb.substring(currentNumb.length()-1).equals(".")){
                  oneDecimalPoint = true;
                }

                // present number with the most recent digit or decimal point removed
                String temp = currentNumb.substring(0, currentNumb.length() - 1);
                MainView.setText(temp);

                // if number is a single digit, set the value back to zero
            } else{
                MainView.setText("0");
            }
        }
    }

    /**
     *
     * @param operation takes in a character to represent the operator
     *
     */
    void handleOperator(char operation ){


        pressedEqualNumb = 0;

        if(error){ // if there is a divide by zero error, set the first operand to zero and assign operation
            this.operand_1=0;
            this.operator=operation;
            MainView.setText(" ");
        }

        // if operator is not defined, set operator and get the first operand
        else if(Objects.equals(lastButtonPressed, "Operator") && operator == ' '){
            this.operator = operation;
            this.operand_1 = Double.parseDouble(MainView.getText().toString());
            MainView.setText(" ");
            // if operator was last pressed, and operator is defined, computer result of previous expression and set no operator.
        } else if (Objects.equals(lastButtonPressed, "Operator") && operator !=' ' && !MainView.getText().toString().equals(" ") && !pressed_Equal && !replaceOperand && operatorPressed==0) {
            ComputeResult();
            this.operator = operation;
            operatorPressed++;
            // if the las button was pressed was eqaul, and the operator was already defined,
        } else if (pressed_Equal && operator!=' ') {
            this.operator = operation; // re assign operator
            this.pressed_Equal = false; // change boolean
            this.operand_1 = Double.parseDouble(MainView.getText().toString()); // assign operand_1 to result of previous calculation
            MainView.setText(" ");
            // case in which replacing the operator with only a single operand defined
        } else if (! pressed_Equal && operator!=' ' && Objects.equals(lastButtonPressed, "Operator") && operatorPressed > 0) { // case to Replace the operator
            this.operator = operation;
            operatorPressed=0;
        }
    }


    /**
     * Function to acutally compute the result
     */
    void ComputeResult(){
        double temp_2=operand_2; // temporary variable assigned to operand 2.

        // if no operator was defined, simply set the result to what is on the screen
        if(operator==' ') {
            result = Double.parseDouble(MainView.getText().toString());
        }
        // assign operand_2 to the temporary value to save previous computation
        if(pressedEqualNumb > 1){
            this.operand_2= temp_2;
        }
        else {
            // no other operand is defined, then operand2 is assigned the value of operand 1
            // Example: 9+= will return 18.
            if (MainView.getText().toString().equals(" ")) {
                this.operand_2 = operand_1;
            } else {
                // other wise, assign operand_2
                this.operand_2 = Double.parseDouble(MainView.getText().toString());
            }
        }

        // if the first operand is defined and the second operator,
         if (!Double.isNaN(operand_1)) {

             switch (operator) { // switch case for the operator

                 case '+':
                     this.result = operand_1 + operand_2; // add and save result
                     break;
                 case '-':
                     this.result = operand_1 - operand_2; // subtract and save result
                     break;
                 case '*':
                     this.result = operand_1 * operand_2; // multiply and save result
                     break;
                 case '/': // divide and save result
                     if (operand_2 ==0) { // ensure the divisor is not zero
                         MainView.setText("ERROR");
                         error=true;
                         return;
                     } else { // other wise perform operation
                         this.result = operand_1 / operand_2;
                     }
                     break;
             }
         }
            if(Math.floor(this.result)==result){ // if result is a whole number, cast as an integer
                int temp_result = (int)this.result;
                MainView.setText(String.valueOf(temp_result));
                this.result = temp_result;
            }else{ // otherwise, present as a double
                MainView.setText(String.valueOf(this.result));
            }
            operand_1= result;
            this.computed = true;
    }

    public void DisplayMainView(String text){
        String currentText = MainView.getText().toString(); // get current text
        pressedEqualNumb = 0; // check how man times equal was pressed

        if(computed||error){  // ensures that after a computation or error, the user can define a new operand.
            MainView.setText(text);
            computed = false;
            error= false;
        } else if(MainView.getText().equals("0")){ // replace text when it is zero.
            MainView.setText(text);
        }else{ // append numbers to the the main view.
            MainView.setText(String.format("%s%s", currentText, text));
        }
    }
}
