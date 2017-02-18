/*
 * Copyright (C) 2017 Luke Klinker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.klinker.android.drag_dismiss;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class DragDismissRecyclerActivity extends AbstractDragDismissActivity {

    protected abstract View setupRecyclerView(RecyclerView recyclerView);

    private RecyclerView recyclerView;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = (RecyclerView) findViewById(R.id.dragdismiss_recycler);
        recyclerView.addOnScrollListener(new ToolbarScrollListener(toolbar, statusBar, primaryColor));
        Utils.changeRecyclerOverscrollColors(recyclerView, primaryColor);

        setupRecyclerView(recyclerView);
    }

    @Override
    protected final int getLayout() {
        return R.layout.dragdismiss_activity_recycler;
    }
}
