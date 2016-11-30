package msk.mylists;

public class Pokemon {

  private String text;
  private String description;
  private String imageUrl;

  private String likeImageUrl;

  public Pokemon(String text, String description, String imageUrl, String likeImageUrl) {
    this.text = text;
    this.description = description;
    this.imageUrl = imageUrl;
    this.likeImageUrl = likeImageUrl;
  }

  public String getLikeImageUrl() {
    return likeImageUrl;
  }

  public String getText() {
    return text;
  }

  public String getDescription() {
    return description;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
