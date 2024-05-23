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

public class RegisterActivity extends AppCompatActivity {

    Button signin_btn, register_btn;

    EditText etName, etMobile, etMail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
    }

    private void addControl() {
        signin_btn = (Button) findViewById(R.id.sign_in);
        register_btn = (Button) findViewById(R.id.sign_up);
    }

    public void Sign_in(View view) {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

    public void Register(View view) {
        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etMail = findViewById(R.id.etMail);
        etPass = findViewById(R.id.etPass);

        // Lấy các giá trị từ layout đăng nhập
        String name = etName.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String mail = etMail.getText().toString().trim();
        String pass = etPass.getText().toString().trim();

        // Validate các giá trị
        if (name.isEmpty()) {
            etName.setError("Vui lòng điền tên");
            return;
        }

        // Kiểm tra tên đăng nhập > 3 ký tự và không chứa ký tự đặc biệt
        if (name.length() < 3 || !name.matches("[a-zA-Z]+")) {
            etName.setError("Tên đăng nhập phải có ít nhất 3 ký tự và chỉ chứa chữ cái");
            return;
        }

        if (mobile.isEmpty()) {
            etMobile.setError("Vui lòng điền số điện thoại");
            return;
        }

        // Kiểm tra số điện thoại là 10 số
        if (mobile.length() != 10 || !mobile.matches("[0-9]+")) {
            etMobile.setError("Số điện thoại phải có 10 chữ số");
            return;
        }

        if (mail.isEmpty()) {
            etMail.setError("Vui lòng điền Email");
            return;
        }

        // Kiểm tra định dạng email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            etMail.setError("Email không hợp lệ");
            return;
        }

        if (pass.isEmpty()) {
            etPass.setError("Vui lòng điền mật khẩu");
            return;
        }

        // Kiểm tra mật khẩu >= 4 ký tự
        if (pass.length() < 4) {
            etPass.setError("Mật khẩu phải có ít nhất 4 ký tự");
            return;
        }

        Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }
}