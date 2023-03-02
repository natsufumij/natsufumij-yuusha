package old;



public class PageModel{
    private Integer pageSize;
    private Integer pageNum;

    public PageModel(Integer pageSize, Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public PageModel() {
    }

    public void validate(){
        if(this.pageNum==null){
            this.pageNum=1;
        }
        if(this.pageSize==null){
            this.pageSize=10;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
