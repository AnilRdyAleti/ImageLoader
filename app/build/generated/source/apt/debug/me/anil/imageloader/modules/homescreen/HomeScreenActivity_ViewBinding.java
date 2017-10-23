// Generated code from Butter Knife. Do not modify!
package me.anil.imageloader.modules.homescreen;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.anil.imageloader.R;

public class HomeScreenActivity_ViewBinding<T extends HomeScreenActivity> implements Unbinder {
  protected T target;

  @UiThread
  public HomeScreenActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.home_screen_tablayout, "field 'tabLayout'", TabLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.home_screen_toolbar, "field 'toolbar'", Toolbar.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.fragment_swipe_refresh_view, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.images_recyclerview, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tabLayout = null;
    target.toolbar = null;
    target.swipeRefreshLayout = null;
    target.recyclerView = null;

    this.target = null;
  }
}
