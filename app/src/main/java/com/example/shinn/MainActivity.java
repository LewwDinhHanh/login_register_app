package com.example.shinn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button login_btn;
    Button register_btn;

    private EditText etUsername, etPassword;
    private Button loginBtn, signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
    }

    private void addControl() {
        login_btn = (Button) findViewById(R.id.login_btn);
        register_btn = (Button) findViewById(R.id.sign_up);
    }

    public void Login(View view) {

        // Lấy các View
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        loginBtn = findViewById(R.id.login_btn);
        signupBtn = findViewById(R.id.sign_up);

        // Lấy các giá trị từ layout đăng nhập
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate các giá trị
        if (username.isEmpty()) {
            etUsername.setError("Vui lòng nhập tên đăng nhập");
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Vui lòng nhập mật khẩu");
            return;
        }

        /// Kiểm tra nếu username và password đúng
        if (username.equals("shinn") && password.equals("9903")) {
            // Nếu các giá trị hợp lệ, chuyển đến trang chính
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        } else {
            // Hiển thị thông báo lỗi
            Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
        }
    }

    public void Signup(View view) {
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }
}