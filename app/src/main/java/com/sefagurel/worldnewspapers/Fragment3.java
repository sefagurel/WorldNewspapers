package com.sefagurel.worldnewspapers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment3 extends Fragment {

	Button		btn3;
	EditText	editText3;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment3, container, false);

		btn3 = (Button) rootView.findViewById(R.id.button3);
		editText3 = (EditText) rootView.findViewById(R.id.editText3);

		Bundle bundle = getArguments();

		if (bundle != null) {
			String strtext = bundle.getString("data1");

			editText3.setText("" + strtext);
		}

		btn3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		return rootView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

}
