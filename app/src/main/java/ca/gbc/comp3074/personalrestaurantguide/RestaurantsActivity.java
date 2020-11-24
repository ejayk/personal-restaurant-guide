package ca.gbc.comp3074.personalrestaurantguide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {


    private TextView restaurantsTitle;
    private ListView restaurantsListView;
    private TextView getRestaurantName;
    private Button delete;
    private EditText etid;
    SQLiteDatabase db;
    DatabaseHelper ourdb;
    ArrayAdapter adapter;
    ArrayList  list;
    //ArrayList list = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurantsTitle = (TextView) findViewById(R.id.restaurantsTitle);
        restaurantsListView = (ListView) findViewById(R.id.restaurantsListView);
        delete=(Button)findViewById(R.id.delete);
        etid = findViewById(R.id.ids);

        //showBtn = (Button) findViewById(R.id.showBtn);
        ourdb = new DatabaseHelper(this);
        showList();
        delete();

        restaurantsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RestaurantsActivity.this, String.valueOf(restaurantsListView.getAdapter().getItem(i)),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showList() {


        //showBtn.setOnClickListener(new View.OnClickListener() {
           // @Override
          //  public void onClick(View view) {

                ArrayList list=new ArrayList();
                list.clear();
                Cursor cursor = ourdb.showData();
                if (cursor.getCount() == 0) {
                    Toast.makeText(RestaurantsActivity.this, "No data", Toast.LENGTH_SHORT).show();
                }
                    while (cursor.moveToNext()) {
                        list.add("Id: "+cursor.getString(0));
                        list.add("Name: "+cursor.getString(1));
                      //  list.add(cursor.getString(2));
                       // list.add(cursor.getString(3));
                       // list.add(cursor.getString(4));
                       // list.add(cursor.getString(5));
                        list.add("Tags: "+cursor.getString(6));
                    }

                   // ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_restaurant_list, R.id.nameTxtView, list);

                    adapter = new ArrayAdapter(RestaurantsActivity.this,android.R.layout.simple_list_item_1, list);
                    restaurantsListView.setAdapter(adapter);
                }

    public void delete()
    {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer delete = ourdb.delete(etid.getText().toString());
                if(delete > 0)
                {
                    Toast.makeText(RestaurantsActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RestaurantsActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    // });
    //}









    //showEntriesFromDatabase();
        /*adapter=new EntryAdapter(this,R.layout.activity_restaurant_list,restaurantsList,database);
        restaurantsListView.setAdapter(adapter);
*/
       /* editBtn=(Button)findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEditRestaurantActivity();
            }
        });*/





        //List<String[]>entries=new ArrayList<String[]>();

/*
        try(BufferedReader br=new BufferedReader(new FileReader("Restaurant-Data.txt"))){
            String line;
            while((line=br.readLine())!=null) {
                String[] entries = line.split("\n");
                entriesall.add(Arrays.asList(entries));


            }
        } catch(IOException e){
            e.printStackTrace();
        }
*/


        /*
        String[]entries;
           try{
                FileInputStream fileInputStream= openFileInput("Restaurant-Data.txt");
                int read=-1;
                StringBuffer buffer=new StringBuffer();
                while((read=fileInputStream.read())!=-1){
                    String[]line;
                    buffer.append((char)read);

                }
                Log.d("Restaurant-Data",buffer.toString());
                String name=buffer.substring(0,buffer.indexOf(","));
                String address=buffer.substring(buffer.indexOf(",")+1);
                String phone=buffer.substring(buffer.indexOf(",")+2);
                String description=buffer.substring(buffer.indexOf(",")+3);
                String rating=buffer.substring(buffer.indexOf(",")+4);
                String tags=buffer.substring(buffer.indexOf(",")+5);


            }catch(Exception e){
                e.printStackTrace();
            }



        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_main,entries);
            ListView listView=(ListView)findViewById(R.id.restaurantsList);
            listView.setAdapter(adapter);



        FileInputStream fis = null;
        String contents = "";
        String array[];
        ArrayList<String> entries = new ArrayList<String>();
        try {
            fis = openFileInput("Restaurant-Data.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
               // System.out.println(line);
                //String[] values = line.split(",");
               // ArrayList<String> row = new ArrayList<String>();
                //Collections.addAll(row, values);
               // entries.add(row);
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {
            contents = stringBuilder.toString();
            array=contents.split("\n");
            Collections.addAll(entries,array);
           // System.out.println(contents);
        }
        using a for loop, iterate over array called array, construct a string using
        the required array elements then push that string into a new array. This new array
        can then be passed into the array adapter for the listview

        for(int i = 0; i<entries.size(); i++){

            String k="Name: "+entries.get(0)+"Tags: "+entries.get(6);


        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_restaurant_list, R.id.entryTextView, entries);
        restaurantsList.setAdapter(adapter);
        restaurantsList.
        View v;
        int count=restaurantsList.getChildCount();

        System.out.println(count);
        for(int i=0;i<count;i++){
            v=restaurantsList.getChildAt(i);
            //TextView nameTextView=(TextView)v.getch
        }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addRestaurant:
                Intent intent = new Intent(this, AddRestaurantActivity.class);
                this.startActivity(intent);
                break;
        }
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                this.startActivity(intent);
                break;
        }
        switch (item.getItemId()) {
            case R.id.restaurantDetails:
                Intent intent = new Intent(this, RestaurantDetailsActivity.class);
                this.startActivity(intent);
                break;
        }
        switch (item.getItemId()) {
            case R.id.restaurants:
                Intent intent = new Intent(this, RestaurantsActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    /*public void openEditRestaurantActivity(){
        Intent intent=new Intent(this,EditRestaurantActivity.class);
        startActivity(intent);
    }*/


}
