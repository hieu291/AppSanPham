package storageitem.intent.data.com.quanlysanpham;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import model.Sanpham;

public class MainActivity extends AppCompatActivity {
    ListView lvSanpham;
    ArrayAdapter<Sanpham> sanphamAdapter;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        lvSanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position , long l) {
                Sanpham sp = sanphamAdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("Sanpham",sp);
                startActivityForResult(intent,100);

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,300);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200){
            boolean isXoa = data.getBooleanExtra("Xacnhanxoa",false);
            Sanpham spXoa = (Sanpham) data.getSerializableExtra("Sanpham");
            for (int i = 0 ; i <= sanphamAdapter.getCount();i++){
                Sanpham sp = sanphamAdapter.getItem(i);
                if (sp.getMa().equals(spXoa.getMa())){
                    sanphamAdapter.remove(sp);
                    break;
                }

            }

        }
    }

    private void addControl() {
        btnAdd = findViewById(R.id.btnAdd);
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
