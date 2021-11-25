package Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sinhvien.kinny.HistoryWeight;
import com.sinhvien.kinny.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HWAdapter extends ArrayAdapter {
    Context context;
    ArrayList<HistoryWeight> arrayList;
    int layout;

    public HWAdapter(@NonNull Context context, int resource, @NonNull ArrayList<HistoryWeight> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layout = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        HistoryWeight hw = arrayList.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout,null);
        }

        TextView tv_Weight = convertView.findViewById(R.id.tv_list_Weight);
        tv_Weight.setText(hw.getWeight());
        TextView tv_BMI = convertView.findViewById(R.id.tv_list_BMI);
        tv_BMI.setText(hw.getBmi());
        TextView tv_Date = convertView.findViewById(R.id.tv_list_Date);
        tv_Date.setText(hw.getDate());

        return convertView;
    }
}