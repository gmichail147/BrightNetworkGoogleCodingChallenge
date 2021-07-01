package com.google;

import java.util.*;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;

  public Boolean paused = false;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");



    for (Video video : videoLibrary.getVideos()) {
      System.out.printf(video.getTitle());
      System.out.printf(" (");
      System.out.printf(video.getVideoId());
      System.out.printf(") [");
      //System.out.printf(video.getTags().toString());

      for (int i = 0; i < video.getTags().size(); i++)
        if (i==video.getTags().size()-1){
          System.out.printf(video.getTags().get(i));
        }
        else {
          System.out.printf(video.getTags().get(i) + " ");
        }

      System.out.println("]");

    }
  }

  ArrayList<String> playArr = new ArrayList<String>();

  public void playVideo(String videoId) {
    Boolean video_error = true;
    for (Video video : videoLibrary.getVideos()) {
      if (videoId.equals(video.getVideoId())){

        video_error = false;

        if (playArr.isEmpty()){
          playArr.add(video.getTitle());
          System.out.println("Playing video: " + playArr.get(0));

        } else{
          stopVideo();
          playVideo(videoId);
        }

      }

    }
    if (video_error){
      System.out.println("Cannot play video: Video does not exist");
    }
  }

  public void stopVideo() {
    String videoId = videoLibrary.getVideos().get(0).getVideoId();
    Video video = videoLibrary.getVideo(videoId);
    if (video == null) {
      System.out.println("Cannot play video: Video does not exist");
    }
    else if(playArr.size() > 0) {
      System.out.println("Stopping video: " + playArr.get(0));
      playArr.remove(0);
      paused = false;

    }else {
      System.out.println("Cannot stop video: No video is currently playing");

    }
  }

  public void playRandomVideo() {

    ArrayList<String> randomArr = new ArrayList<String>();

    for (Video video : videoLibrary.getVideos()){
      randomArr.add(video.getVideoId());
    }

    Random rand = new Random();

    // Generate random integers in range 0 to 999
    int rand_int = rand.nextInt(5);
    playVideo(randomArr.get(rand_int));
  }

  public void pauseVideo() {

    String videoId = videoLibrary.getVideos().get(0).getVideoId();
    Video video = videoLibrary.getVideo(videoId);
    if (video == null) {
      System.out.println("Cannot play video: Video does not exist");
    }
    else if(playArr.size() > 0) {
      if (paused){
        System.out.println("Video already paused: " + playArr.get(0));

      } else {
        System.out.println("Pausing video: " + playArr.get(0));
        paused=true;
      }

    }else {
      System.out.println("Cannot pause video: No video is currently playing");

    }
  }

  public void continueVideo() {
    String videoId = videoLibrary.getVideos().get(0).getVideoId();
    Video video = videoLibrary.getVideo(videoId);
    if (video == null) {
      System.out.println("Cannot play video: Video does not exist");
    }
    else if(playArr.size() > 0) {
      if (paused){
        System.out.println("Continuing video: " + playArr.get(0));
      } else {
        System.out.println("Cannot continue video: Video is not paused");
      }

    }else {
      System.out.println("Cannot continue video: No video is currently playing");

    }
  }

  public void showPlaying() {
    String videoId = videoLibrary.getVideos().get(0).getVideoId();
    Video video = videoLibrary.getVideo(videoId);
    if (video == null) {
      System.out.println("Cannot play video: Video does not exist");
    }
    else if(playArr.size() > 0) {
      for (Video v : videoLibrary.getVideos()) {
        if (v.getTitle().equals(playArr.get(0))){
          System.out.printf("Currently playing: ");
          System.out.printf(v.getTitle());
          System.out.printf(" (");
          System.out.printf(v.getVideoId());
          System.out.printf(") [");


          for (int i = 0; i < v.getTags().size(); i++){
            if (i==v.getTags().size()-1){
              System.out.printf(v.getTags().get(i));
            }
            else {
              System.out.printf(v.getTags().get(i) + " ");
            }
          }



          if (paused){
            System.out.println("] - PAUSED");
          } else {
            System.out.println("]");
          }
        }
      }

    }else {
      System.out.println("No video is currently playing");

    }
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}