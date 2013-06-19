package comment;

import java.util.Date;

public class Comment {

	// Fields

	private Integer commentId;
	private Integer usersId;
	private Integer foodId;
	private Date commentDate;
	private String commentText;

	// Constructors

	/** default constructor */
	public Comment() {
		
	}

	/** full constructor */
	public Comment(Integer usersId, Integer foodId,
			Date commentDate, String commentText) {
		this.usersId = usersId;
		this.foodId = foodId;
		this.commentDate = commentDate;
		this.commentText = commentText;
	}

	//Property accessors
	
	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	
	

}
