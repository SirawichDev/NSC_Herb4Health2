package com.example.asus.herb4health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.List;

public class Newlist extends AppCompatActivity {
    ListView ListView;
    List<Herb> herbList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlist);
        prepareData();

        ListView = (android.widget.ListView) findViewById(R.id.list_item2);
        //Adapter
        ListAdapter adapter = new ListAdapter(Newlist.this,herbList);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(Newlist.this,"อาการที่"+position,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Newlist.this,ShowDetail.class);
                intent.putExtra("image",herbList.get(position).getResId());
                intent.putExtra("breed",herbList.get(position).getBreed());
                intent.putExtra("description",herbList.get(position).getDrescription());

                startActivity(intent);

            }
        });

    }

    private void prepareData() {
        int resId[] = {R.drawable.disease2, R.drawable.disease3, R.drawable.disease4, R.drawable.disease5
                , R.drawable.disease6, R.drawable.disease7, R.drawable.disease8, R.drawable.disease15, R.drawable.disease9,
                R.drawable.disease16};

        String breed[] = {"กลุ่มสมุนไพรลดไขมันในเส้นเลือด", "กลุ่มสมุนไพรรักษาโรคผิวหนังกลากเกลื้อน", "กลุ่มพืชหอมเป็นยาบำรุงหัวใจ", "กลุ่มถ่ายพยาธ",
                "กลุ่มแก่อาการท้องอืดท้องเฟ้อ", "กลุ่มสมุนไพรเพื่อความสวยความงาม", "กลุ่มสมุนไพรแก้ท้องร่วง", "กลุ่มสมุนไพรขับเสมหะ", "กลุ่มสมุนไพรลดความร้อน",
                "กลุ่มสมุนไพรบำรุงร่างกาย"};

        String description[] = {getString(R.string.กลุ่มสมุนไพรลดไขมันในเส้นเลือด),
                getString(R.string.กลุ่มสมุนไพรรักษาโรคผิวหนังกลากเกลื้อน),
                getString(R.string.กลุ่มพืชหอม),
                getString(R.string.กลุ่มยาถ่ายพยาธิ)
                , getString(R.string.กลุ่มแก้อาการท้องอืดท้องเฟ้อ),
                getString(R.string.กลุ่มสมุนไพรเพื่อความสวยความงาม),
                getString(R.string.กลุ่มสมุนไพรแก้บิด),
                getString(R.string.กลุ่มสมุนไพรขับเสมหะแก้ไอ),
                getString(R.string.กลุ่มสมุนไพรลดความร้อน),
                getString(R.string.กลุ่มสมุนไพรบำรุงกำลังบำรุงธาตุ)};
        int dataSize = resId.length;
        for (int i = 0; i < dataSize; i++) {
            Herb herb = new Herb(resId[i], breed[i], description[i]);
            herbList.add(herb);

        }
    }
}
