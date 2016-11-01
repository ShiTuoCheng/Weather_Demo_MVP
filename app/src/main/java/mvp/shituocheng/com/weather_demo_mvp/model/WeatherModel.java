package mvp.shituocheng.com.weather_demo_mvp.model;

/**
 * Created by shituocheng on 2016/10/29.
 */

public class WeatherModel {

    private String date;
    private String fengli;
    private String fengxiang;
    private String high;
    private String low;
    private String type;

    public WeatherModel(Builder builder) {
        this.date = builder.date;
        this.fengli = builder.fengli;
        this.fengxiang = builder.fengxiang;
        this.high = builder.high;
        this.low = builder.low;
        this.type = builder.type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Builder{

        private String date;
        private String fengli;
        private String fengxiang;
        private String high;
        private String low;
        private String type;

        public Builder fengli(String fengli){
            this.fengli = fengli;
            return this;
        }

        public Builder date(String date){
            this.date = date;
            return this;
        }

        public Builder fengxiang(String fengxiang){
            this.fengxiang = fengxiang;
            return this;
        }

        public Builder high(String high){
            this.high = high;
            return this;
        }

        public Builder low(String low){
            this.low = low;
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public WeatherModel build(){
            return new WeatherModel(this);
        }

    }
}
