[![Build Status](https://travis-ci.org/Mahtalitet/udacity-project1.svg?branch=master)](https://travis-ci.org/Mahtalitet/udacity-project1)

[![Udacity logo](https://s3-us-west-1.amazonaws.com/udacity-content/images/reviews/twitter-thumbnail-neutral.png)](https://review.udacity.com/#!/reviews/447773/shared)

# Android Developer Nanodegree
Udacity Project - Popular Movies, Stage 1

## How set API key
1. Create file **gradle.properties** in the _poject/app_ directory.
2. Add API KEY like this:
`THE_MOVIE_DB_API_KEY = 111111`

where **111111** corresponding api key.

## Goals
Goal | Progress
------------ | -------------
Movies are displayed in the main layout via a grid of their corresponding movie poster thumbnails. | Resolved 
UI contains an element (i.e a spinner or settings menu) to toggle the sort order of the movies by: most popular, highest rated. | Resolved
UI contains a screen for displaying the details for a selected movie. | Resolved
Movie details layout contains **title**, **release date**, **movie poster**, **vote average**, and **plot synopsis**. | Resolved
When a user changes the sort criteria (“most popular and highest rated”) the main view gets updated correctly. | Resolved
When a movie poster thumbnail is selected, the movie details screen is launched. | Resolved
In a background thread, app queries the **/movie/popular** or **/movie/top_rated** API for the sort criteria specified in the settings menu. | Resolved

## Libs, plugins, extensions
Retrofit</br>
Moshi</br>
OkHttp3</br>
Moxy</br>
AutoValue</br>
AutoParcel</br>
Dagger2</br>
Picasso</br>
Timber</br>
Calligraphy</br>
ButterKnife</br>
Support Libs</br>
StreamsSupport</br>
retrolambda</br>
