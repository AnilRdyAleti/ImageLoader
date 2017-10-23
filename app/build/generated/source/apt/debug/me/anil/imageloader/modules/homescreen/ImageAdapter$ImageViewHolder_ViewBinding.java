// Generated code from Butter Knife. Do not modify!
package me.anil.imageloader.modules.homescreen;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.anil.imageloader.R;

public class ImageAdapter$ImageViewHolder_ViewBinding<T extends ImageAdapter.ImageViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public ImageAdapter$ImageViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.imageView, "field 'imageView'", AppCompatImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.imageView = null;

    this.target = null;
  }
}
