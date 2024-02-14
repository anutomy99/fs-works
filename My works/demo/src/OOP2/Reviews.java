package OOP2;

public class Reviews {
    private int reviewId;
    private String comment;
    private int rating;

    public Reviews(int reviewId, String comment, int rating) {
        this.reviewId = reviewId;
        this.comment = comment;
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Review id : %d comment : %s, rating : %d \n",reviewId,comment,rating);
    }
}
