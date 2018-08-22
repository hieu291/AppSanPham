package storageitem.intent.data.com.quanlysanpham;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import model.Sanpham;

public class DetailActivity extends AppCompatActivity {
    EditText edtMa,edtTen,edtGia;
    Button btnXoa,btnBack;
    Intent intent;
    Sanpham sp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogXoa();
            }
        });
    }

    private void showDialogXoa() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_xoa);
        Button btnYes =  dialog.findViewById(R.id.btnYes);
        Button btnNo = dialog.findViewById(R.id.btnNo);
        dialog.show();
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    truyenDulieu();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    private void truyenDulieu() {
        intent.putExtra("Xacnhanxoa",true);
        intent.putExtra("Sanpham",sp);
        setResult(200,intent);
        finish();
        Toast.makeText(DetailActivity.this,"Xoa thanh cong",Toast.LENGTH_SHORT).show();
    }


    private void addControl() {
        edtGia = findViewById(R.id.edtGia);
        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);

        btnBack = findViewById(R.id.btnBack);
        btnXoa = findViewById(R.id.btnXoa);

        intent = getIntent();
         sp = (Sanpham) intent.getSerializableExtra("Sanpham");
        edtMa.setText(sp.getMa());
        edtTen.setText(sp.getTen());
        edtGia.setText(sp.getGia()+"");
    }
}
