package cn.mycloudway.pojo;

public class Brand {
    private int id;
    private String brandName;
    private String companyName;
    private int ordered;
    private int status;
    private String description;

    public Brand() {
    }

    public Brand(String brandName, String companyName, int ordered, int status, String description) {
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.status = status;
        this.description = description;
    }

    public Brand(int id, String brandName, String companyName, int ordered, int status, String description) {
        this(brandName, companyName, ordered, status, description);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
