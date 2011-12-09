package com.wenkaihu.mp3downloader.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.wenkaihu.mp3downloader.R;

public class ResultsAct extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_results_list);
		setTitle(R.string.result_title);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"a", "b"}));
		
	}

}
