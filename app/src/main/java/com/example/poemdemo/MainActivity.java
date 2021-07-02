package com.example.poemdemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.ViewCompat;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabRefresh;
    //    Toolbar mToolbar;
    TextView tvTitle;
    TextView tvAuthor;
    TextView tvContent;
    ScrollView svContent;

    List<Poem> mPoems = new ArrayList<>();
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ViewCompat.setNestedScrollingEnabled(svContent, true);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mPoems = Poem.getDefaultPoem();
    }

    private void initView() {
        svContent = findViewById(R.id.sv_content);
//        mToolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tv_title);
        tvAuthor = findViewById(R.id.tv_author);
        tvContent = findViewById(R.id.tv_content);
        fabRefresh = findViewById(R.id.fab_refresh);
        fabRefresh.setOnClickListener(view -> {
            Random random = new Random();
            Poem poem = mPoems.get(random.nextInt(51));
            updatePoem(poem);
        });
    }

    private void updatePoem(Poem poem) {
        tvTitle.setText(poem.getTitle());
        tvAuthor.setText(poem.getAuthor());
        tvContent.setText(poem.getContent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        final MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setQueryHint(getString(R.string.search_hint_text));  //设置输入前得提示文字
        searchView.setIconifiedByDefault(false);

        //设置输入内容监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //用户点击搜索
                for (Poem p : mPoems) {
                    if (p.getTitle().indexOf(query) != -1) {
                        updatePoem(p);
                        break;
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //搜索的内容改变
                return false;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }
}