package cn.mycloudway.pojo;

public class Brand {
    private Integer id;
    private String brandName;
    private String companyName;
    private Integer ordered;
    private Integer status;
    private String description;

    public Brand() {
    }

    public Brand(String brandName, String companyName, Integer ordered, Integer status, String description) {
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.status = status;
        this.description = description;
    }

    public Brand(Integer id, String brandName, String companyName, Integer ordered, Integer status, String description) {
        this(brandName, companyName, ordered, status, description);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
