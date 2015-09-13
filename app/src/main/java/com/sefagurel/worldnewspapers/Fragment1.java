package com.sefagurel.worldnewspapers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

	Button		btn1;
	EditText	editText1;

	Communicator communicator;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment1, container, false);

		btn1 = (Button) rootView.findViewById(R.id.button1);
		editText1 = (EditText) rootView.findViewById(R.id.editText1);

		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				String str = editText1.getText().toString();

				Bundle bundle = new Bundle();
				bundle.putString("data1", str);

				communicator.setCurrentPage(2, bundle);
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

		communicator = (Communicator) context;

	}
}
