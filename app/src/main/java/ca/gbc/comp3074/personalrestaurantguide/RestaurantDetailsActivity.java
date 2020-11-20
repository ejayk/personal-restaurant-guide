package ca.gbc.comp3074.personalrestaurantguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantDetailsActivity extends AppCompatActivity {
    private ImageButton fbBtn, twBtn, mailBtn;
    private Button locBtn, directionBtn;
    private TextView nameTxt, addressTxt, phoneTxt, descriptionTxt, tagsTxt;
    private TextView nameLbl, addressLbl, phoneLbl, descriptionLbl, tagsLbl, ratingLbl;
    private RatingBar ratingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_restaurant);

        fbBtn = (ImageButton) findViewById(R.id.fbBtn);
        twBtn = (ImageButton) findViewById(R.id.twitterBtn);
        mailBtn = (ImageButton) findViewById(R.id.mailBtn);

        locBtn = (Button) findViewById(R.id.locBtn);
        directionBtn = (Button) findViewById(R.id.directionBtn);

        nameTxt=(TextView)findViewById(R.id.nameTxt);
        addressTxt=(TextView)findViewById(R.id.addressTxt);
        phoneTxt=(TextView)findViewById(R.id.phoneTxt);
        descriptionTxt=(TextView)findViewById(R.id.descriptionTxt);
        tagsTxt=(TextView)findViewById(R.id.tagsTxt);

        nameLbl=(TextView)findViewById(R.id.nameLabel);
        addressLbl=(TextView)findViewById(R.id.addressLabel);
        phoneLbl=(TextView)findViewById(R.id.phoneLabel);
        descriptionLbl=(TextView)findViewById(R.id.descriptionLabel);
        tagsLbl=(TextView)findViewById(R.id.tagsLabel);
        ratingLbl=(TextView) findViewById(R.id.ratingLabel);

        ratingBar=(RatingBar) findViewById(R.id.ratingBarStatic);

        //back arrow button
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


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
}
