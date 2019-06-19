package cn.com.asadal.beans;

/**
 * Created by User on 2016-6-28.
 */
public class Nodes {
	private String id;
	private String name;
	private String des;
	public ItemStyle getItemStyle() {
		return itemStyle;
	}

	public void setItemStyle(ItemStyle itemStyle) {
		this.itemStyle = itemStyle;
	}


	private ItemStyle itemStyle;
	private String category;
    public String getSymbolSize() {
		return symbolSize;
	}

	public void setSymbolSize(String symbolSize) {
		this.symbolSize = symbolSize;
	}


	private String symbolSize;
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}