package food;

public class FoodPicture {
	private Integer foodPicId;
	private Integer foodId;
	private String foodPicUrl;
	
	//
	public FoodPicture(){
		
	}
	public FoodPicture(Integer foodId,String foodPicUrl){
		this.foodId=foodId;
		this.foodPicUrl=foodPicUrl;
	}
	//
	public Integer getFoodPicId() {
		return foodPicId;
	}
	public void setFoodPicId(Integer foodPicId) {
		this.foodPicId = foodPicId;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFoodPicUrl() {
		return foodPicUrl;
	}
	public void setFoodPicUrl(String foodPicUrl) {
		this.foodPicUrl = foodPicUrl;
	}
	

}
