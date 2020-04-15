package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //mainactivity view를 설정하는
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); //getmenuinflater는 metinflation을 하는 객체
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //만들어진 menu가 선택되었을 때 호출출는 메소드
        int id = item.getItemId();
        if (id == R.id.action_signUp) {
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_memo) {
           Intent intent = new Intent(this, MemoActivity.class);
           startActivity(intent);
            return true;
        } else if ( id == R.id.action_buttons){
            Intent intent = new Intent(this, ButtonsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_checkboxes){
            Intent intent = new Intent(this, CheckboxesActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_spinners) {
            Intent intent = new Intent(this, SpinnersActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_alerts) {
            Intent intent = new Intent(this, AlertsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



