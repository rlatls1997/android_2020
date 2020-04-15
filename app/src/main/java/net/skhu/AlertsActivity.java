package net.skhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlertsActivity extends AppCompatActivity {
    int selectedAnimalIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);



    }

    public void button1_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.saveSuccess);   //저장성공 메세지 출력
        builder.setNeutralButton(R.string.close, null);    //닫기' 라는 text의 버튼 생성
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void button2_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int index){
                Toast.makeText(AlertsActivity.this, "삭제성공", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.no, null); //null은 더 실행될 게 없다는 뜻
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void button3_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(R.array.animals, selectedAnimalIndex,null);
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int index){ //확인버튼 클릭시 호출됨
                ListView listView = ((AlertDialog)dialog).getListView();
                selectedAnimalIndex = listView.getCheckedItemPosition();
                String msg = selectedAnimalIndex + " 번째 항목이 선택되었습니다.";
                Toast.makeText(AlertsActivity.this, msg, Toast.LENGTH_SHORT).show();

                int drawabledId = 0;
                switch(selectedAnimalIndex){
                    case 0: drawabledId = R.drawable.animal_cat_large; break;
                    case 1: drawabledId = R.drawable.animal_dog_large; break;
                    case 2: drawabledId = R.drawable.animal_owl_large; break;
                }
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawabledId);
            }
        });
        builder.setNegativeButton(R.string.cancel, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void button4_clicked(View button){
        List<String> stringList = new ArrayList<String>();
        stringList.addAll(Arrays.asList("고양이","강아지","부엉이"));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(adapter, selectedAnimalIndex, null);
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int index){ //확인버튼 클릭시 호출됨
                ListView listView = ((AlertDialog)dialog).getListView();
                selectedAnimalIndex = listView.getCheckedItemPosition();
                String msg = (selectedAnimalIndex+1) + " 번째 항목이 선택되었습니다.";
                Toast.makeText(AlertsActivity.this, msg, Toast.LENGTH_SHORT).show();

                int drawabledId = 0;
                switch(selectedAnimalIndex){
                    case 0: drawabledId = R.drawable.animal_cat_large; break;
                    case 1: drawabledId = R.drawable.animal_dog_large; break;
                    case 2: drawabledId = R.drawable.animal_owl_large; break;
                }
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawabledId);
            }
        });
        builder.setNegativeButton(R.string.cancel, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void button5_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setNeutralButton(R.string.dog, new DialogInterface.OnClickListener(){

            int drawabledId = 0;
            @Override
            public void onClick(DialogInterface dialog, int index){
                drawabledId = R.drawable.animal_dog_large;
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawabledId);
            }

        });
        builder.setNegativeButton(R.string.owl, new DialogInterface.OnClickListener(){

            int drawabledId = 0;
            @Override
            public void onClick(DialogInterface dialog, int index){
                drawabledId = R.drawable.animal_owl_large;
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawabledId);
            }
        });
        builder.setPositiveButton(R.string.cat, new DialogInterface.OnClickListener(){

            int drawabledId = 0;
            @Override
            public void onClick(DialogInterface dialog, int index){
                drawabledId = R.drawable.animal_cat_large;
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawabledId);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }



}
