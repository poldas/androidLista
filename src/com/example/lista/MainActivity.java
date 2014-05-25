package com.example.lista;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	
	String KOMUNIKAT = "Włączony";
	private static final String[] ELEMENTS = {
		"Element numer 1", "Drugi element", "A tutaj trzeci!"
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // zmiana tekstu
        TextView tvTest1 = (TextView) findViewById(R.id.textMain);
        tvTest1.setText("Jakiś tekst");

        // ustawienie danych do wyświetlenia na liście
        final ListView newsEntryListView = (ListView) findViewById(R.id.listMain);
        final NewsEntryAdapter newsEntryAdapter = new NewsEntryAdapter(this, R.layout.news_entry_list_item);
        newsEntryListView.setAdapter(newsEntryAdapter);
        
        // Populate the list, through the adapter
        for(final NewsEntry entry : getNewsEntries()) {
        	newsEntryAdapter.add(entry);
        }
        // krótkie powiadomienia
        Toast.makeText(getApplicationContext(), KOMUNIKAT, Toast.LENGTH_LONG).show();
    }

    private List<NewsEntry> getNewsEntries() {
    	
    	// Let's setup some test data.
    	// Normally this would come from some asynchronous fetch into a data source
    	// such as a sqlite database, or an HTTP request
    	
    	final List<NewsEntry> entries = new ArrayList<NewsEntry>();
    	Integer viewNumber = 0;
    	for(int i = 1; i < 50; i++) {
    		int random = (int)(Math.random() * 4 + 1);
    		switch (random) {
			case 0:
				viewNumber = R.drawable.dancing;
				break;
			case 1:
				viewNumber = R.drawable.note;
				break;
			case 2:
				viewNumber = R.drawable.quote;
				break;
			case 3:
				viewNumber = R.drawable.ic_launcher;
				break;

			default:
				break;
			}
    		entries.add(
	    		new NewsEntry(
    				"Test Entry " + i,
    				"Anonymous Author " + i,
    				new GregorianCalendar(2014, 05, i).getTime(),
    				viewNumber 
	    		)
	    	);
    	}
    	
    	return entries;
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
//            switch (pos) {
//	            case 0:
//	                startActivity(new Intent(MainActivity.this, MainActivity.class));
//	                break;
//            }
//     
	}

}
