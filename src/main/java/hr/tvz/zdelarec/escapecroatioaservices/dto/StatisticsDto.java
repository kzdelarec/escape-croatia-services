package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Statistics DTO class.
 *
 * @author kristijan.zdelarec
 */
public class StatisticsDto {

    /**
     * Statistics DTO content type.
     */
    public static final String CONTENT_TYPE = "application/statistics.v1+json";

    @NotNull
    private BigDecimal rating;
    @NotNull
    private BigDecimal successRate;

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(final BigDecimal rating) {
        this.rating = rating;
    }

    public BigDecimal getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(final BigDecimal successRate) {
        this.successRate = successRate;
    }

    @Override
    public String toString() {
        return "StatisticsDto{" +
                "rating=" + rating +
                ", successRate=" + successRate +
                '}';
    }
}
