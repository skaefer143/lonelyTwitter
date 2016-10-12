package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The type Lonely twitter activity.
 */
public class LonelyTwitterActivity extends Activity {

	private Activity activity = this;

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	public ListView getOldTweetsList(){
		return oldTweetsList;
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		final Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		//save button
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				bodyText.setText("");
				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});

		//clear button
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);

				bodyText.setText("");
				tweetList.clear();
				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(activity, EditTweetActivity.class);
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			//converting ArrayList into Gson ?
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			//fancy file saving
			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();


			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}