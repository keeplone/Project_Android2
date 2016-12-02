package com.example.keeplone.project_android2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IdealweightFragment extends Fragment {

    private TextView txtBmi, txtResult;
    private EditText edtWeight, edtHeight;
    private Button calButton;
    private String weightString, heightString, bmiResult;



    public IdealweightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup bmiView = (ViewGroup) inflater.inflate(R.layout.fragment_idealweight, container, false);

        edtHeight = (EditText) bmiView.findViewById(R.id.editText);
        edtWeight = (EditText) bmiView.findViewById(R.id.editText2);
        calButton = (Button) bmiView.findViewById(R.id.btn1);
        txtBmi = (TextView) bmiView.findViewById(R.id.textView3);
        txtResult = (TextView) bmiView.findViewById(R.id.textView4);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                weightString = edtWeight.getText().toString().trim();
                heightString = edtHeight.getText().toString().trim();

                if (weightString.length() < 1){

                    MsgAlert alert = new MsgAlert();
                    alert.myDialog(getActivity(), R.drawable.error, "Please fill in all fields", "Please Input Start Weight555");
                    return;
                }
                if (heightString.length() < 1){
                    MsgAlert alert = new MsgAlert();
                    alert.myDialog(getActivity(), R.drawable.error, "Please fill in all fields", "Please Input Current Weight");
                    return;
                }

                float weight = Float.valueOf(weightString);
                float height = Float.valueOf(heightString);
                float Wp = ((height - weight)/height) * 100;
                //float BMI = weight / (height * height) * 10000;

                txtBmi.setText(String.valueOf("Weight Loss Percent = "+Wp));

                //bmiResult = "s";

                //txtResult.setText(String.valueOf(bmiResult));

               /* if (height > weight){
                    bmiResult = "- "+Wp;
                }
                else if (weight > height){
                    bmiResult = "+ "+Wp;
                }*/

               /* if(BMI < 18.5){
                    bmiResult = "underweight11111";
                }
                else if(BMI < 25){

                    bmiResult = "healthy";

                }
                else if(BMI < 30){

                    bmiResult = "overweight";
                }
                else{
                    bmiResult = "obese";
                }*/
            }
        });

        getActivity().setTitle("Weight Loss");
        // Inflate the layout for this fragment
        return bmiView;

    }


}
