package storageitem.intent.data.com.quanlysanpham;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import model.Sanpham;

public class MainActivity extends AppCompatActivity {
    ListView lvSanpham;
    ArrayAdapter<Sanpham> sanphamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
    }

    private void addControl() {
        lvSanpham = findViewById(R.id.lvSanpham);
        sanphamAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item);
        lvSanpham.setAdapter(sanphamAdapter);
        sanphamAdapter.add(new Sanpham("sp1","Coca",15000));
        sanphamAdapter.add(new Sanpham("sp2","Bimbim",25000));
        sanphamAdapter.add(new Sanpham("sp3","Redbull",35000));
        sanphamAdapter.add(new Sanpham("sp4","Nuoc dua",45000));
        sanphamAdapter.add(new Sanpham("sp5","Cocktail",55000));
    }
}
