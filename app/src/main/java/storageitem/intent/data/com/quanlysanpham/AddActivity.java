package storageitem.intent.data.com.quanlysanpham;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    Button btnAddsanpham;
    EditText edtMa;
    EditText edtTen;
    EditText edtGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        addcontrol();
        addevent();
    }

    private void addevent() {
        btnAddsanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSanpham();
            }
        });

    }

    private void addSanpham() {

    }

    private void addcontrol() {
        btnAddsanpham = findViewById(R.id.btnAddsanpham);

        edtGia = findViewById(R.id.edtGia);
        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);

    }
}
