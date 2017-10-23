// Generated code from Butter Knife. Do not modify!
package me.anil.imageloader.modules.detail;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.anil.imageloader.R;

public class DetailActivity_ViewBinding<T extends DetailActivity> implements Unbinder {
  protected T target;

  @UiThread
  public DetailActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.titleTextView = Utils.findRequiredViewAsType(source, R.id.detail_title_textview, "field 'titleTextView'", TextView.class);
    target.descriptionTextView = Utils.findRequiredViewAsType(source, R.id.detail_description_textview, "field 'descriptionTextView'", TextView.class);
    target.simpleDraweeViewBody = Utils.findRequiredViewAsType(source, R.id.bodyImage, "field 'simpleDraweeViewBody'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.titleTextView = null;
    target.descriptionTextView = null;
    target.simpleDraweeViewBody = null;

    this.target = null;
  }
}
