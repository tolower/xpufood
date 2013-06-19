package food;


public class Food {

	// Fields

	private Integer foodId;
	private Integer restaurantId;
	private String foodName;
	private Integer foodPrice;
	private String foodType;
	private Integer foodLevel;
	private Integer foodLovecount;
	private Integer foodEatedcount;
	private Integer foodWanteatcount;
	//private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(Integer restaurantId, String foodName,
			Integer foodPrice, String foodType) {
		this.restaurantId = restaurantId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodType = foodType;
	}

	/** full constructor */
	public Food(Integer restaurantId, String foodName,
			Integer foodPrice, String foodType, Integer foodLevel,
			Integer foodLovecount, Integer foodEatedcount,
			Integer foodWanteatcount) {
		this.restaurantId = restaurantId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodType = foodType;
		this.foodLevel = foodLevel;
		this.foodLovecount = foodLovecount;
		this.foodEatedcount = foodEatedcount;
		this.foodWanteatcount = foodWanteatcount;
		
	}

	// Property accessors

	public Integer getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getRestaurantId() {
		return this.restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getFoodPrice() {
		return this.foodPrice;
	}

	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodType() {
		return this.foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public Integer getFoodLevel() {
		return this.foodLevel;
	}

	public void setFoodLevel(Integer foodLevel) {
		this.foodLevel = foodLevel;
	}

	public Integer getFoodLovecount() {
		return this.foodLovecount;
	}

	public void setFoodLovecount(Integer foodLovecount) {
		this.foodLovecount = foodLovecount;
	}

	public Integer getFoodEatedcount() {
		return this.foodEatedcount;
	}

	public void setFoodEatedcount(Integer foodEatedcount) {
		this.foodEatedcount = foodEatedcount;
	}

	public Integer getFoodWanteatcount() {
		return this.foodWanteatcount;
	}

	public void setFoodWanteatcount(Integer foodWanteatcount) {
		this.foodWanteatcount = foodWanteatcount;
	}
}
