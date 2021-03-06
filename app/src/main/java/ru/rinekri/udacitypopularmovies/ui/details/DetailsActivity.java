package ru.rinekri.udacitypopularmovies.ui.details;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import jp.wasabeef.picasso.transformations.BlurTransformation;
import ru.rinekri.udacitypopularmovies.BuildConfig;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.ui.base.models.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;

import static ru.rinekri.udacitypopularmovies.ui.UiConstants.BLUR_RADIUS;

public class DetailsActivity extends BaseMvpActivity<DetailsPM> implements DetailsView {
  private static final String EXTRA_MOVIE_SHORT_INFO = BuildConfig.APPLICATION_ID + ".extra_short_info";
  private static final String EXTRA_TITLE = BuildConfig.APPLICATION_ID + ".extra_title";

  public static void start(Context context,
                           @NonNull MovieShortInfo movieShortInfo) {
    Intent intent = new Intent(context, DetailsActivity.class);
    intent.putExtra(EXTRA_MOVIE_SHORT_INFO, movieShortInfo);
    intent.putExtra(EXTRA_TITLE, movieShortInfo.title());
    context.startActivity(intent);
  }

  @NonNull
  private String getStartTitle() {
    return getIntent().getStringExtra(EXTRA_TITLE);
  }

  @BindView(R.id.backdrop)
  ImageView moviePoster;
  @BindView(R.id.details_release_date)
  TextView releaseDate;
  @BindView(R.id.details_vote_average)
  TextView voteAverage;
  @BindView(R.id.details_overview)
  TextView overview;

  @InjectPresenter
  public DetailsPresenter presenter;

  @ProvidePresenter
  public DetailsPresenter providePresenter() {
    return new DetailsPresenter(getIntent().getParcelableExtra(EXTRA_MOVIE_SHORT_INFO));
  }

  @Override
  protected ActivityConfig provideActivityConfig() {
    return ActivityConfig.builder()
      .contentViewRes(R.layout.content_details)
      .titleText(getStartTitle())
      .useBackButton(true)
      .alignElceCenter(false)
      .build();
  }

  @Override
  public void showViewContent(DetailsPM data) {
    super.showViewContent(data);
    Picasso
      .with(this)
      .load(data.movieInfo().posterPath())
      .transform(new BlurTransformation(this, BLUR_RADIUS))
      .into(moviePoster);
    voteAverage.setText(data.movieInfo().voteAverage());
    overview.setText(data.movieInfo().overview());
    releaseDate.setText(data.movieInfo().releaseDate());
  }
}