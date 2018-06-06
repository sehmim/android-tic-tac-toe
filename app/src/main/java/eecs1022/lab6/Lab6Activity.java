package eecs1022.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab6Activity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);

    }
    private void displayThis(int id, String newContent){
        View view = findViewById(id);
        TextView textview = (TextView) view;
        textview.setText(newContent);
    }
    private String getInput(int id){
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }
    private String getSelectedInput(int id){
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String mySpinner = spinner.getSelectedItem().toString();
        return mySpinner;
    }

    public void startGame(View view){
        game = new Game();
        game.checkingWhoPlaysFirst(getSelectedInput(R.id.firstPlayer));
        displayThis(R.id.namePlayerX, game.displayBoard());
    }

    public void playGame(View view){
        game.play(Integer.parseInt(getSelectedInput(R.id.rowSpinner)),Integer.parseInt(getSelectedInput(R.id.colomnSpinner)));
    }
}
