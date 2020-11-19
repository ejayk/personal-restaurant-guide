package ca.gbc.comp3074.personalrestaurantguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {

    private TextView restaurantsTitle;
    private TextView getRestaurantName;
    private TextView getTags;
    private ListView restaurantsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurantsTitle=(TextView)findViewById(R.id.restaurantsTitle);
        restaurantsList=(ListView)findViewById(R.id.restaurantsList);

        //List<String[]>entries=new ArrayList<String[]>();
      /* String[]entriesall = new String[];

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


           /* try{
                FileInputStream fileInputStream= openFileInput("Restaurant-Data.txt");
                String line;
                int read=-1;
                StringBuffer buffer=new StringBuffer();
                while((read=fileInputStream.read())!=-1){
                    buffer.append((char)read);

                }
                Log.d("Restaurant-Data",buffer.toString());
                String name=buffer.substring(0,buffer.indexOf(","));
                String address=buffer.substring(buffer.indexOf(",")+1);
                String phone=buffer.substring(buffer.indexOf(",")+2);
                String description=buffer.substring(buffer.indexOf(",")+3);
                String rating=buffer.substring(buffer.indexOf(",")+4);
                String tags=buffer.substring(buffer.indexOf(",")+5);
                entries= new String[]{name, address,}


            }catch(Exception e){
                e.printStackTrace();
            }
            */

        /*
        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_main,entries);
            ListView listView=(ListView)findViewById(R.id.restaurantsList);
            listView.setAdapter(adapter);

            */





    }

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
            case R.id.restaurants:
                Intent intent = new Intent(this, RestaurantsActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


}
