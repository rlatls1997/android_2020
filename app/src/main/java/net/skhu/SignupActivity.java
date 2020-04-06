package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //signupactivy가 create될 때 자동으로 실행
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup); //layout리소스에 정의된대로 view를 생성하여 set =layoutonflation

        Button button = (Button)findViewById(R.id.button); //버튼의 id를 찾아서 버튼객체참조
        View.OnClickListener listener = new View.OnClickListener() { //anonymous inner클래스 = 이름이 없고 onclick메소드 내에서만 만듬ㄹ
            @Override                                                //outer클래스의 메소드를 사용하기 위함함
            public void onClick(View view) {
               EditText editText_loginId = (EditText)findViewById(R.id.editText_loginId); //edittext에대한참조를 구한다
                String loginId = editText_loginId.getText().toString();
                if (isEmptyOrWhiteSpace(loginId))
                    editText_loginId.setError("로그인 아이디를 입력하세요");

                EditText editText_password = (EditText)findViewById(R.id.editText_password);
                String password = editText_password.getText().toString();
                if (isEmptyOrWhiteSpace(password))
                    editText_password.setError("비밀번호를 입력하세요");

                EditText editText_password2 = (EditText)findViewById(R.id.editText_password2);
                String password2 = editText_password2.getText().toString();
                if (password.equals(password2) == false)
                    editText_password2.setError("비밀번호가 일치하지 않습니다");

                EditText editText_email = (EditText)findViewById(R.id.editText_email);
                String email = editText_email.getText().toString();

                // 회원 가입 데이터를 서버에 전송하는 코드를 구현해야 함.

                String msg = "회원가입 성공: " + loginId + " " + email;
                Toast.makeText(SignupActivity.this, msg, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(SignupActivity.this, MemoActivity.class);
                startActivity(intent);


            }
        };
        button.setOnClickListener(listener); //리스너객체를 버튼객체에 연결
    }

    static boolean isEmptyOrWhiteSpace(String s) { //null이거나 공백이거나 length가 0경우 true리턴
        if (s == null) return true;
        return s.trim().length() == 0;
    }
}

