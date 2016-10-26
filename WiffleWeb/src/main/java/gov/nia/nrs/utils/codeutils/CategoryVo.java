/**
 * Copyright 2012 (C) Hyweb Technology. All Rights Reserved.
 *
 * Date:2012/7/26 下午1:48:00 User: Carl Desc: 新加註解
 */

package gov.nia.nrs.utils.codeutils;

import java.io.Serializable;

/**
 * @author <a href=”mailto:carl.lu@hyweb.com.tw”>Carl Lu</a>
 * @version Revision: 1 2012/7/26 下午1:48:00
 */
public class CategoryVo implements Comparable<CategoryVo>, Serializable {

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;

    /** 代碼類別編號 */
    private String category;

    /** 代碼類別名稱 */
    private String categoryName;

    private String id;

    @Override
    public int compareTo(CategoryVo item) {
        if (null == item)
            return -1;
        if (null == this.category)
            return -1;
        if (null == item.category)
            return 1;
        if (this.category.matches("\\d*") && item.category.matches("\\d*"))
            return Integer.parseInt(this.category) - Integer.parseInt(item.category);
        else
            return this.category.compareTo(item.category);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CategoryVo [category=");
        builder.append(category);
        builder.append(", categoryName=");
        builder.append(categoryName);
        builder.append("]");
        return builder.toString();
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
