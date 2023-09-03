package com.example.link;

import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {
    private static final int MENU_ITEM_DISPLAY = 1;
    private static final int MENU_ITEM_SHARE = 2;
    private List<ImageModel> imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageList = new ArrayList<>();
        ImageView myImageView = findViewById(R.id.my_image_view);
        registerForContextMenu(myImageView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.image_menu, menu);

        menu.add(Menu.NONE, MENU_ITEM_DISPLAY, Menu.NONE, "Display");
        menu.add(Menu.NONE, MENU_ITEM_SHARE, Menu.NONE, "Share");
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_DISPLAY:
                handleDisplay(item);
                return true;
            case MENU_ITEM_SHARE:
                handleShare();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    private void handleDisplay(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        ImageModel selectedImage = imageList.get(info.position);

        ImageView myImageView = findViewById(R.id.my_image_view);
        myImageView.setImageURI(Uri.parse(selectedImage.getImagePath()));
    }

    private void handleShare() {

    }
}

